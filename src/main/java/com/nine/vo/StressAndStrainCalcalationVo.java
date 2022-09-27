package com.nine.vo;

import lombok.Data;

import java.util.List;

@Data
public class StressAndStrainCalcalationVo {
    // 项目id
    private Integer proId;
    // 结构编号

    private Integer sNum;

    private Integer structuralNum;

    // 层数
    private Integer layerNum;
    // 结构层信息实体
    private List<StructuralLayerVo> structuralLayers;
    // 荷载个数
    private Integer loadNum;
    // 荷载参数实体
    private List<LoadVo> loads;
    // TODO 这里的数据前端没有，传不到这里，需要修改
    // 计算点位个数
    private Integer calcalationNum;
    // 计算点位实体
    private List<CalcaulationPointVo> calcaulationPoints;

}
