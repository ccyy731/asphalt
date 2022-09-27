package com.nine.entity;

/**
 * 不同控制指标下的当量轴载换算系数
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ealf")
public class EalfEntity {
    // id 主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // 控制指标[0代表沥青层永久变形和疲劳开裂，1代表无机结合料层永久变形和疲劳开裂，2代表土基顶面压应变]
    private Integer controlIndicator;
    // 车辆满载水平[0代表非满载车，1代表满载车]
    private Integer vehicleType;
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
    // 项目id
    private Integer proId;
}
