package com.nine.entity;

/**
 * 项目基本信息
 */

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("project_info")
public class ProjectInfoEntity {
    // 项目id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // 项目名称
    private String projectName;
    // 项目文件名称
    private String projectFilename;
    // 公路等级
    private String highwayLevel;
    // 设计使用年限
    private Integer designLife;
    // 所在省份
    private String province;
    // 公路路面设计类型
    private String designType;
    // 备注信息
    private String description;

    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+8")
    private Date createTime;
    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+8")
    private Date updateTime;
}
