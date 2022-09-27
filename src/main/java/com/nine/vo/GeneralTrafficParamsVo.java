package com.nine.vo;


import lombok.Data;

/**
 * 该Vo用于将查询到的一般交通参数页面的交通参数和车辆类型分布系数数据进行返回
 */
@Data
public class GeneralTrafficParamsVo {
    // AADTT(日/辆)
    private Integer aadtt;
    // 交通增长率(%)
    private Double growthRate;
    // 方向系数(%)
    private Double directionCoefficient;
    // 车道系数(%)
    private Double laneCoefficient;

    // 类型2-11系数(%)
    private Double type2;
    private Double type3;
    private Double type4;
    private Double type5;
    private Double type6;
    private Double type7;
    private Double type8;
    private Double type9;
    private Double type10;
    private Double type11;
}
