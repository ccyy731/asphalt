package com.nine.entity;

/**
 * 一般交通参数
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("traffic_parameters")
public class TrafficParaEntity {
    //id 主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // AADTT(日/辆)
    private Integer aadtt;
    // 交通增长率(%)
    private Double growthRate;
    // 方向系数(%)
    private Double directionCoefficient;
    // 车道系数(%)
    private Double laneCoefficient;
    // 项目id
    private Integer proId;

}
