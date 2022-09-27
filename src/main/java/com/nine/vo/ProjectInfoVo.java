package com.nine.vo;

import lombok.Data;

@Data
public class ProjectInfoVo{

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
}
