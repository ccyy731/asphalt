package com.nine.utils.calculatin;

/**
 * 路面结构验算
 *      2.无机结合料稳定层疲劳开裂验算
 */
public class InorganicLayerFatigueCrackCalculation {

    /**
     * 现场综合修正系数，按式(B.2.1-2)确定
     * @param ha    沥青混合料层厚度
     * @param hb    计算点以上无机结合料稳定层厚度
     * @param type  0：无机结合料稳定粒料  1：无机结合料稳定土
     * @return kc   现场综合修正系数
     */
    public double correctionFactor(int ha, int hb, int type){
        // 参数，按表B.2.1-2取值
        double c1, c2, c3;
        // 无机结合料稳定粒料
        if(type == 0){
            c1 = 14.0;
            c2 = -0.0076;
            c3 = -1.47;
        }else {
            // 无机结合料稳定土
            c1 = 35.0;
            c2 = -0.0156;
            c3 = -0.83;
        }
        double kc = c1 * Math.exp(c2 * (ha + hb)) + c3;
        return kc;
    }

    /**
     * 季节性冻土地区调整系数，按表B.1.1确定
     * @param F 冻结指数F(℃·d)
     * @return ka 季节性冻土地区调整系数
     */
    public double frozenSoilAdjustmentFactor(int F){
        double ka = 0;
        if(F >= 2000){
            // 0.60 ~ 0.70
            ka = (Math.random() * 10 + 60) / 100;
        } else if (F > 200) {
            // 0.70 ~ 0.80
            ka = (Math.random() * 10 + 70) / 100;
        } else if (F > 50) {
            // 0.80 ~ 1.00
            ka = (Math.random() * 20 + 80) / 100;
        }else {
            // 1.00
            ka = 1.00;
        }
        return ka;
    }


    /**
     * 无机结合料稳定层疲劳开裂验算
     * @param ka    季节性冻土地区调整系数，按表B.1.1确定
     * @param kT2   温度调整系数，根据规范附录G确定
     * @param Rs    无机结合料稳定类材料的弯拉强度(MPa)
     * @param type  0：无机结合料稳定粒料  1：无机结合料稳定土
     * @param kc    现场综合修正系数，按式(B.2.1-2)确定
     * @param reliableIndicator β：目标可靠指标，根据公路等级按表3.0.1取值
     * @param bottomTensileStress   σt:无机结合料稳定层的层底拉应力(MPa)，根据弹性层状体系理论，按规范第6.2.2条的规定选取计算点
     * @return Nf2 无机结合料稳定层疲劳开裂寿命(轴次)
     */
    public double inorganicLayerFatigueCrack(double ka, double kT2, double Rs, int type, double kc,
                                             double reliableIndicator, double bottomTensileStress){
        // 疲劳试验回归参数，按表B.2.1-1确定
        double a,b;
        // 无机结合料稳定粒料
        if(type == 0){
            a = 13.24;
            b = 12.52;
        }else {
            // 无机结合料稳定土
            a = 12.18;
            b = 12.79;
        }
        double Nf2 = ka * (1 / kT2) * Math.pow(10, a - b * bottomTensileStress / Rs +kc - 0.57 * reliableIndicator);
        return Nf2;
    }















}
