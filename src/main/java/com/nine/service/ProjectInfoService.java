package com.nine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nine.common.utils.PageUtils;
import com.nine.entity.ProjectInfoEntity;
import com.nine.entity.TrafficParaEntity;

import java.util.Map;


public interface ProjectInfoService extends IService<ProjectInfoEntity> {
    PageUtils queryByCondition(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);

    void updateByIdDetail(ProjectInfoEntity projectInfoEntity);

    ProjectInfoEntity getByProId(int id);
}
