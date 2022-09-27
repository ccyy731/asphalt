package com.nine.entity;

/**
 * 非满载车、满载车比例
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vehicle_proportion")
public class VehicleProportionEntity {
    // id 主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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
