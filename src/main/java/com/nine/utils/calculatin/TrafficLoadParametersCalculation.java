package com.nine.utils.calculatin;

import com.nine.entity.EalfEntity;
import com.nine.entity.TrafficParaEntity;
import com.nine.entity.VehicleProportionEntity;
import com.nine.entity.VehicleTypeDistributionEntity;

/**
 * 交通荷载参数计算
 *    1.设计年限内设计车道累计交通量
 *    2.确定设计交通荷载等级
 *    3.计算当量设计轴载换算系数(水平三)
 */
public class TrafficLoadParametersCalculation {

    /**
     * 计算设计年限内设计车道累计交通量
     * @param trafficParaEntity 一般交通参数（aadtt、γ、ddf、ldf）
     * @param year 设计年限
     * @return
     */
    public double trafficCalculate(TrafficParaEntity trafficParaEntity, int year) {
        // AADTT（辆/日）：2 轴6 轮及以上车辆的双向初期年平均日交通量
        int aadtt = trafficParaEntity.getAadtt();
        // γ（交通增长率）
        double growthRate = trafficParaEntity.getGrowthRate();
        // DDF（方向系数）
        double ddf = trafficParaEntity.getDirectionCoefficient();
        // LDF（车道系数）
        double ldf = trafficParaEntity.getLaneCoefficient();

        // 设计车道的年平均日货车交通量
        double q1 = aadtt * ddf * ldf;
        // 设计年限内设计车道累计交通量
        double q = (365 * q1 * (Math.pow((1+growthRate), year) - 1)) / growthRate;
        return q;
    }

    /**
     * 确定设计交通荷载等级
     * @param q 设计年限内设计车道累计交通量
     * @return 设计交通荷载等级
     */
    public String loadClassCalculate(double q){
        // 单位为10^6
        double q6 = q / 1000000;
        String level = "";
        if(q6 >= 50){
            level = "极重";
        }else if(q6 >= 19){
            level = "特重";
        }else if(q6 >= 8){
            level = "重";
        }else if(q6 >= 4){
            level = "中等";
        }else{
            level = "轻";
        }
        return level;
    }

    /**
     * * 计算当量设计轴载换算系数（水平三）
     *      * 根据规范(A.3.1-5) P35
     *      * 公式： EALF_m = EALF_ml * PER_ml + EALF_mh * PER_mh
     *      *      m —— 车辆类型编号
     *      *      l —— 非满载
     *      *      h —— 满载
     *      *      ealf —— 当量设计轴载换算系数
     *      *      per —— 非满载车或满载车所占的百分比
     * @param ealfL 非满载车的当量设计轴载换算系数
     * @param ealfH 满载车的当量设计轴载换算系数
     * @param perL  非满载车所占的百分比
     * @param perH  满载车所占的百分比
     * @return  m类车辆的当量设计轴载换算系数 数组
     */
    public double[] EALFCalculate(EalfEntity ealfL, EalfEntity ealfH, VehicleProportionEntity perL, VehicleProportionEntity perH) {
        double[] ealfLs = ealfEntity2Array(ealfL);
        double[] ealfHs = ealfEntity2Array(ealfH);
        double[] perLs = vehicleProportionEntity2Array(perL);
        double[] perHs = vehicleProportionEntity2Array(perH);
        double[] ealfMs = new double[12];
        for (int i = 2; i < 12; i++) {
            ealfMs[i] = ealfLs[i] * perLs[i] + ealfHs[i] * perHs[i];
        }
        return ealfMs;
    }

    /**
     * 当量设计轴载换算系数 实体转数组
     * @param ealfEntity
     * @return
     */
    public double[] ealfEntity2Array(EalfEntity ealfEntity){
        double[] ealfs = new double[12];
        ealfs[2] = ealfEntity.getType2();
        ealfs[3] = ealfEntity.getType3();
        ealfs[4] = ealfEntity.getType4();
        ealfs[5] = ealfEntity.getType5();
        ealfs[6] = ealfEntity.getType6();
        ealfs[7] = ealfEntity.getType7();
        ealfs[8] = ealfEntity.getType8();
        ealfs[9] = ealfEntity.getType9();
        ealfs[10] = ealfEntity.getType10();
        ealfs[11] = ealfEntity.getType11();
        return ealfs;
    }

    /**
     * 车辆比例 实体转数组
     * @param vehicleProportionEntity
     * @return
     */
    public double[] vehicleProportionEntity2Array(VehicleProportionEntity vehicleProportionEntity){
        double[] pers = new double[12];
        pers[2] = vehicleProportionEntity.getType2();
        pers[3] = vehicleProportionEntity.getType3();
        pers[4] = vehicleProportionEntity.getType4();
        pers[5] = vehicleProportionEntity.getType5();
        pers[6] = vehicleProportionEntity.getType6();
        pers[7] = vehicleProportionEntity.getType7();
        pers[8] = vehicleProportionEntity.getType8();
        pers[9] = vehicleProportionEntity.getType9();
        pers[10] = vehicleProportionEntity.getType10();
        pers[11] = vehicleProportionEntity.getType11();
        return pers;
    }

    /**
     * 车辆类型分布系数 实体转数组
     * @param vehicleTypeDistributionEntity 车辆类型分布系数 实体
     * @return 车辆类型分布系数 数组
     */
    public double[] VehicleTypeDistributionEntity2Array(VehicleTypeDistributionEntity vehicleTypeDistributionEntity){
        double[] vcdfs = new double[12];
        vcdfs[2] = vehicleTypeDistributionEntity.getType2();
        vcdfs[3] = vehicleTypeDistributionEntity.getType3();
        vcdfs[4] = vehicleTypeDistributionEntity.getType4();
        vcdfs[5] = vehicleTypeDistributionEntity.getType5();
        vcdfs[6] = vehicleTypeDistributionEntity.getType6();
        vcdfs[7] = vehicleTypeDistributionEntity.getType7();
        vcdfs[8] = vehicleTypeDistributionEntity.getType8();
        vcdfs[9] = vehicleTypeDistributionEntity.getType9();
        vcdfs[10] = vehicleTypeDistributionEntity.getType10();
        vcdfs[11] = vehicleTypeDistributionEntity.getType11();
        return vcdfs;
    }

    /**
     * 当量设计轴载累计作用次数
     * 公式(A.4.1)  N1 = AADTT * DDF * LDF * Σ(VCDFm * EALFm)
     * 公式(A.4.2)  Ne = [(1+γ)^t - 1] / γ * 365 * N1
     * @param q 设计年限内设计车道累计交通量
     * @param ealfMs m类车辆的当量设计轴载换算系数
     * @param vcdfs m类车辆类型分布系数
     * @return 当量设计轴载累计作用次数
     */
    public double cumulativeActionTimes(double q, double[] ealfMs, double[] vcdfs){

        double sum = 0;
        for (int i = 2; i < 12; i++) {
            sum += vcdfs[i] * ealfMs[i];
        }
        double Ne = q * sum;

        return Ne;
    }


}
