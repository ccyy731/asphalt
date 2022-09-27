package com.nine.utils.calculatin;

public class DeflectionCheckCalculation {


    /**
     * 路基顶面验收弯沉值
     * @param E     路基标准状态下回弹模量(MPa)
     * @param ks    回弹模量湿度调整系数
     * @return lg   路基顶面验收弯沉值(0.01mm)
     */
    public double subgradeTopSurfaceDeflection(int E, double ks){
        // 平衡湿度状态下路基顶面回弹模量(MPa)
        double E0 = E * ks;
        // 落锤式弯沉仪承载板施加荷载(MPa)
        double p = 0.707355;
        // 落锤式弯沉仪承载板半径(mm)
        int r = 150;
        // 路基顶面验收弯沉值(0.01mm)
        double lg = 176 * p * r / E0;
        return lg;
    }

    /**
     * 路表验收弯沉值
     * @return la 路表验收弯沉值(0.01mm)
     */
    public double roadSurfaceDeflection(){
        return 1.0;
    }
}
