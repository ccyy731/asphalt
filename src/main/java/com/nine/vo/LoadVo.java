package com.nine.vo;

import lombok.Data;

@Data
public class LoadVo {
    // 单位压力（MPa）
    private Double unitPressure;
    // 荷载半径（cm）
    private Double loadRadius;
    // 位置x
    private Double positionX;
    // 位置y
    private Double positionY;
}
