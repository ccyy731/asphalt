package com.nine.entity;

/**
 * 环境信息
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("environment")
public class EnvironmentEntity {
    // id 主键
    @TableId(value = "eid", type = IdType.AUTO)
    private Integer eid;
    // 沥青层永久变形基准等效温度（℃）
    private Double equivalentTemperature;
    // 基准路面结构温度调整系数（结构层疲劳）
    private Double tcfStructural;
    // 基准路面结构温度调整系数（路基顶面压应变）
    private Double tcfTop;
    // 冻结指数（℃•日）
    private Double freezeIndex;
    // 季节性冻土地区调整系数
    private Double seasonalFreeze;
    // 项目id
    private Integer proId;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Double getEquivalentTemperature() {
        return equivalentTemperature;
    }

    public void setEquivalentTemperature(Double equivalentTemperature) {
        this.equivalentTemperature = equivalentTemperature;
    }

    public Double getTcfStructural() {
        return tcfStructural;
    }

    public void setTcfStructural(Double tcfStructural) {
        this.tcfStructural = tcfStructural;
    }

    public Double getTcfTop() {
        return tcfTop;
    }

    public void setTcfTop(Double tcfTop) {
        this.tcfTop = tcfTop;
    }

    public Double getFreezeIndex() {
        return freezeIndex;
    }

    public void setFreezeIndex(Double freezeIndex) {
        this.freezeIndex = freezeIndex;
    }

    public Double getSeasonalFreeze() {
        return seasonalFreeze;
    }

    public void setSeasonalFreeze(Double seasonalFreeze) {
        this.seasonalFreeze = seasonalFreeze;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "eid=" + eid +
                ", equivalentTemperature=" + equivalentTemperature +
                ", tcfStructural=" + tcfStructural +
                ", tcfTop=" + tcfTop +
                ", freezeIndex=" + freezeIndex +
                ", seasonalFreeze=" + seasonalFreeze +
                ", proId=" + proId +
                '}';
    }
}
