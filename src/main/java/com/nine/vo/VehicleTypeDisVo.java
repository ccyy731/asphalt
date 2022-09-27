package com.nine.vo;

import lombok.Data;

/**
 * 该Vo用于接收前端传来的数据，查询一般交通参数页面的交通参数和车辆类型分布系数
 */
@Data
public class VehicleTypeDisVo {

    // 项目ID
    private Integer proId;
    // 水平
    private Integer level;
    // ttc
    private Integer ttc;
}
