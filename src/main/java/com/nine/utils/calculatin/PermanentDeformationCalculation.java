package com.nine.utils.calculatin;

import java.util.ArrayList;
import java.util.List;

/**
 * 路面结构验算
 *    1.沥青混合料层永久变形验算
 */
public class PermanentDeformationCalculation {

    /**
     * 计算等效温度
     * 根据规范公式(G.2.1)
     * @param equivalentTemperature 基准等效温度，按所在地查表G.1.2取用
     * @param thickness 沥青混合料层厚度(mm)
     * @return Tpef 沥青混合料层等效温度(℃)
     */
    public double asphaltLayerEquivalentTemperature(double equivalentTemperature, int thickness){
        double tPef = equivalentTemperature + 0.016 * thickness;
        return tPef;
    }

    /**
     * 分层
     * 按规范 B.3.1
     *    1.表面层，采用10-20mm为一分层  面层的最上面一层
     *    2.第二层沥青混合料层，每一分层厚度应不大于25mm
     *    3.第三层沥青混合料层，每一分层厚度应不大于100mm
     *    4.第四层及其以下沥青混合料层，作为一个分层
     *    例子： 上面层(表面层)为40mm，可分为20、20两层
     *          中面层(第二层沥青混合料层)为50mm，可分为25、25两层
     *          下面层(第三层沥青混合料层)为80mm，小于100mm，可直接80作为一层
     *    注：第二层和第三层沥青混合料层也可能是基层采用沥青混合料，不一定非要是面层
     * @param hFirst 上面层厚度
     * @param hSecond 第二层厚度
     * @param hThird 第三层厚度
     * @return 分层列表(有效索引从1开始)
     */
    public List<Integer> layered(int hFirst, int hSecond, int hThird){
        List<Integer> layers = new ArrayList<>();
        // 第0层为0 => 索引为0作废 方便后面计算
        layers.add(0);

        // 表面层分层 按20mm分
        while(hFirst > 20){
            layers.add(20);
            hFirst -= 20;
        }
        if(hFirst < 10){
            layers.set(layers.size() - 1, 10);
            layers.add(hFirst + 10);
        }else{
            layers.add(hFirst);
        }

        // 第二层分层 按25mm分
        while(hSecond > 25){
            layers.add(25);
            hSecond -= 25;
        }
        if(hSecond < 10){
            layers.set(layers.size() - 1, 10);
            layers.add(hSecond + 10);
        }else{
            layers.add(hSecond);
        }

        // 第三层分层 按100mm分 一般用不到
        while(hThird > 100){
            layers.add(100);
            hThird -= 100;
        }
        if(hThird < 10){
            layers.set(layers.size() - 1, 10);
            layers.add(hThird + 10);
        }else{
            layers.add(hThird);
        }

        return layers;
    }

    /**
     * 综合修正系数 Comprehensive correction factor
     *     按式(B.3.2-2) ~ (B.3.2-4)计算
     * @param layers 各分层厚度列表
     * @return 每一分层的综合修正系数 数组
     */
    public double[] comprehensiveCorrectionFactor(List<Integer> layers){
        // 层数
        int size = layers.size();
        // ha：沥青混合料层厚度(mm)，ha大于200mm时，取200mm
        int ha = 0;
        for (Integer layer : layers) {
            ha += layer;
        }
        if (ha > 200) {
            ha = 200;
        }

        // (B.3.2-3)
        double d1 = -1.35 * 1e-4 * ha * ha + 8.18 * 1e-2 * ha - 14.50;

        // (B.3.2-4)
        double d2 = 8.78 * 1e-7 * ha * ha - 1.50 * 1e-3 * ha + 0.90;

        // z_i: 沥青混合料层第i分层深度(mm)，第一分层取15mm，其他分层为路表距分层中点的深度
        double[] z = new double[size];
        z[0] = 15;
        int sum = 0;
        for (int i = 1; i < size; i++) {
            sum += layers.get(i-1);
            z[i] = sum + layers.get(i) / 2.0;
        }

        // k_R: 综合修正系数
        double[] kR = new double[size];
        for (int i = 0; i < kR.length; i++) {
            // (B.3.2-2)
            kR[i] = (d1 + d2 * z[i]) * Math.pow(0.9731, z[i]);
        }

        return kR;
    }

    /**
     * 各沥青混合料分层的永久变形量
     * @param Tpef  沥青混合料层永久变形等效温度(℃)，根据规范附录G确定
     * @param Ne3   设计使用年限内或通车至首次针对车辙维修的期限内，设计车道上当量设计轴载累计作用次数，按规范附录A计算
     * @param h0    车辙试验试件的厚度(mm)
     * @param R0    每一分层沥青混合料在试验温度为60℃，压强为0.7MPa，加载次数为2520次时，车辙试验永久变形量(mm) 数组
     * @param layers 每一层的分层厚度(mm) 列表
     * @param kR    每一层的综合修正系数 数组
     * @param p     沥青混合料层第i分层顶面竖向压应力(Mpa)，根据弹性层状体系理论，按规范第6.2.2条规定选取计算点 数组
     * @return Ra  第i分层永久变形量(mm) 数组
     */
    public double[] permanentDeformation(double Tpef, double Ne3, double h0, double[] R0, List<Integer> layers, double[] kR, double[] p){
        // n: 分层数
        int n = layers.size();
        double[] Ra = new double[n];
        for (int i = 0; i < n; i++) {
            Ra[i] = 2.31 * 1e-8 * kR[i] * Math.pow(Tpef, 2.93) * Math.pow(p[i], 1.80) * Math.pow(Ne3, 0.48) * (layers.get(i) / h0) * R0[i];
        }
        return Ra;
    }

    /**
     * 沥青混合料层永久变形量(总)
     * @param Ra 第i分层永久变形量(mm) 数组
     * @return 沥青混合料层永久变形量
     */
    public double permanentDeformationSum(double[] Ra){
        double RaSum = 0;
        for (double v : Ra) {
            RaSum += v;
        }
        return RaSum;
    }

}
