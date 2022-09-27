package com.nine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.entity.EalfEntity;
import com.nine.mapper.EalfMapper;
import com.nine.service.EalfService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EalfServiceImpl extends ServiceImpl<EalfMapper, EalfEntity> implements EalfService {
    @Override
    public List<EalfEntity> getByProId(int proid, int index) {
        if(StringUtils.checkValNotNull(proid) && StringUtils.checkValNotNull(index)){
            // 这里设置一个list，用于同一个控制指标下保存满载车和非满载车的比例数据，同时该表下的查询也应该设置一下
            List<EalfEntity> entities = this.getBaseMapper().selectList(new QueryWrapper<EalfEntity>().eq("pro_id", proid).eq("control_indicator", index));
            return entities;
        }
        return null;
    }

    @Override
    public void updateByProIdAndIndicator(List<EalfEntity> ealfEntities) {
        for (EalfEntity ealfEntity : ealfEntities) {
            this.update(ealfEntity, new UpdateWrapper<EalfEntity>()
                    .eq("pro_id", ealfEntity.getProId())
                    .eq("control_indicator", ealfEntity.getControlIndicator())
                    .eq("vehicle_type", ealfEntity.getVehicleType()));
        }
    }
}
