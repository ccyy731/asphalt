package com.nine.entity;

/**
 * 结构与材料参数
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("structural")
public class StructuralEntity {

    // 结构id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // 层位[0代表面层，1代表基层，2代表底基层，3代表路基]
    private Integer horizon;
    // 材料类型[0代表沥青结合料材料，1代表无机结合料材料,2代表粒料材料]
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


}
