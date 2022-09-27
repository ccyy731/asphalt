package com.nine.vo;

import lombok.Data;

@Data
public class StructuralLayerVo {
    // 模量(Mpa)
    private Integer modulus;
    // 泊松比
    private Double poissonRatio;
    // 厚度
    private Integer thickness;
    // 界面接触系数
    private Integer interfaceContactCoefficient;
}
