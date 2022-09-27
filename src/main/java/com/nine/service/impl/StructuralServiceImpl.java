package com.nine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.entity.StructuralEntity;
import com.nine.entity.StructuralMaterialEntity;
import com.nine.mapper.StructuralMapper;
import com.nine.service.StructuralMaterialService;
import com.nine.service.StructuralService;
import com.nine.vo.StructuralInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StructuralServiceImpl extends ServiceImpl<StructuralMapper, StructuralEntity> implements StructuralService {

    @Autowired
    StructuralMaterialService materialService;

    @Override
    public List<StructuralEntity> getBatchByProId(int proid) {
        if(StringUtils.checkValNotNull(proid)){
            List<StructuralEntity> entityList = this.list(new QueryWrapper<StructuralEntity>().eq("pro_id", proid));
            return entityList;
        }
        return null;
    }

    @Transactional
    @Override
    public StructuralInfoVo getInfoById(int id) {
        StructuralInfoVo vo = new StructuralInfoVo();

        if(StringUtils.checkValNotNull(id)){
            // 查找结构实体
            StructuralEntity structuralEntity = this.getOne(new QueryWrapper<StructuralEntity>().eq("id", id));
            if(structuralEntity != null){
                BeanUtils.copyProperties(structuralEntity, vo);

                // 根据结构实体的id去结构材料表里查找材料信息
                Integer sid = structuralEntity.getId();
                StructuralMaterialEntity materialEntity = materialService.getOne(new QueryWrapper<StructuralMaterialEntity>().eq("structural_id", sid));
                if(materialEntity != null){
                    BeanUtils.copyProperties(materialEntity, vo);
                }
            }
            return vo;
        }
        return null;
    }

    @Transactional
    @Override
    public void updateInfoVo(StructuralInfoVo infoVo) {
        // 更新结构表的信息
        StructuralEntity structuralEntity = new StructuralEntity();
        BeanUtils.copyProperties(infoVo, structuralEntity);
        this.updateById(structuralEntity);

        // 更新材料表的信息
        StructuralMaterialEntity materialEntity = new StructuralMaterialEntity();
        BeanUtils.copyProperties(infoVo, materialEntity);
        // 获取结构表的id，如果sid是空的话说明是第一次更新材料信息，还需要把这个id保存到材料表的中
        if(infoVo.getStructuralId() == null){
            // 第一次编辑需要设置sid后进行保存
            materialEntity.setStructuralId(infoVo.getId());
            materialService.save(materialEntity);
        }
        materialService.update(materialEntity, new UpdateWrapper<StructuralMaterialEntity>().eq("structural_id", infoVo.getStructuralId()));
    }

    @Override
    public void removeStructuralMaterialByIds(List<Integer> ids) {
        // 首先根据ids批量删除结构表的信息
        this.removeByIds(ids);
        // 然后根据材料表的sid批量删除材料信息
        for (Integer id : ids) {
            StructuralMaterialEntity materialEntity = materialService.getOne(new QueryWrapper<StructuralMaterialEntity>().eq("structural_id", id));
            if(materialEntity != null){
                materialService.remove(new QueryWrapper<StructuralMaterialEntity>().eq("structural_id", id));
            }
        }
    }
}
