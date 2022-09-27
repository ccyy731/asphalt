package com.nine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nine.entity.StructuralEntity;
import com.nine.vo.StructuralInfoVo;

import java.util.List;


public interface StructuralService extends IService<StructuralEntity> {
    List<StructuralEntity> getBatchByProId(int proid);

    StructuralInfoVo getInfoById(int id);

    void updateInfoVo(StructuralInfoVo infoVo);

    void removeStructuralMaterialByIds(List<Integer> ids);
}
