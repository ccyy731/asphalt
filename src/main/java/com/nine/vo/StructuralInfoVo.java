package com.nine.vo;

import lombok.Data;

@Data
public class StructuralInfoVo {
    private Integer id;
    // 层位（面层 基层 底基层 土基）
    private Integer horizon;
    // 材料类型
    private Integer materialType;
    // 材料名称
    private String materialName;
    // 厚度（mm）
    private Integer thickness;
    // 泊松比
    private Double poissonRatio;
    // 模量（Mpa）
    private Integer modulus;
    // 说明
    private String description;
    // 沥青层疲劳方程调整系数c1，当材料类型为沥青结合料时才设置该参数
    private Double adjustmentCoefficient;
    // 沥青混合料沥青饱和度，当材料类型为沥青结合料时才设置该参数
    private Double asphaltSaturation;
    // 无机结合料层弯拉强度，当材料类型为无机结合料时才设置该参数
    private Double bendingTensileStrength;
    // 项目id
    private Integer proId;

    // 结构id，structural表里的id
    private Integer structuralId;
    // 材料类型[0代表沥青结合料材料，1代表无机结合料材料,2代表粒料材料]
    private Integer type;
    // 无机结合料稳定类材料类型[0代表无机结合料稳定粒料，1代表无机结合料稳定土]
    private Integer inorganicType;
    // 输入水平[0代表水平一，1代表水平二，2代表水平三]，可以分别代表沥青层输入水平和回填模量输入水平
    private Integer inputLevel;
    // 动态压缩模量，水平一的唯一参数
    private Integer dynamicCompressionModulus;

    // 沥青动态剪切模量，属于水平二
    private Integer dynamicShearModulus;
    // 空隙率，属于水平二
    private Double voidRatio;
    // 油石比，属于水平二
    private Double oilStoneRatio;
    // 粗集料空隙率，属于水平二
    private Double coarseAggregatePorosity;
    // 频率，属于水平二
    private Double frequency;

    // 沥青混合料动态模量，属于水平三
    private Double dynamicModulus;

    // 车辙试验试件的厚度，属于永久变形相关参数
    private Double testPieceThickness;
    // 车辙试验永久变形量，属于永久变形相关参数
    private Double permanentDeformation;
    // 沥青混合料的贯入强度，属于永久变形相关参数
    private Double penetrationStrength;

    //结构层弹性模量（Mpa），属于无机结合料材料参数
    private Integer structuralElasticModulus;

    // 粒料材料回弹模量，属于粒料材料参数
    private Integer granularElasticModulus;
    // 湿度调整系数，属于粒料材料参数
    private Double humidityCofficient;

    // 回填模量输入水平
    private Double resilientModulusLevel;
    // 土基回弹模量
    private Double subgradeResilientModulus;
    // CBR
    private Double cbr;
    // 干湿与冻融循环作用折减系数，属于路基参数
    private Double reductionCoefficient;
}
