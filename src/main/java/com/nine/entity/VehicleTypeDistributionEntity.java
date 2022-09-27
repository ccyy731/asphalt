package com.nine.entity;

/**
 * 车辆类型分布系数
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.beans.IntrospectionException;

@Data
@TableName("vehicle_type_distribution_coefficient")
public class VehicleTypeDistributionEntity {
    // id 主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 水平[0代表水平一/二，1代表水平三]
     */
    private Integer level;
    /**
     *ttc[1代表TTC1，2代表TTC2,3代表TTC3，4代表TTC4,5代表TTC5]
     */
    private Integer ttc;
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
