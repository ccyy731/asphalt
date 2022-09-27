package com.nine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.entity.VehicleProportionEntity;
import com.nine.mapper.VehiclePropotionMapper;
import com.nine.service.VehiclePropotionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclePropotionServiceImpl extends ServiceImpl<VehiclePropotionMapper, VehicleProportionEntity> implements VehiclePropotionService {
    @Override
    public List<VehicleProportionEntity> getByProId(int proid) {
        if(StringUtils.checkValNotNull(proid)){
            // 查询当前项目下的满载和非满载两种车型比例返回list
            List<VehicleProportionEntity> entities = this.getBaseMapper().selectList(new QueryWrapper<VehicleProportionEntity>().eq("pro_id", proid));
            return entities;
        }
        return null;
    }

    @Override
    public void updateByProIdAndType(List<VehicleProportionEntity> entities) {
        for (VehicleProportionEntity entity : entities) {
            this.update(entity, new UpdateWrapper<VehicleProportionEntity>()
            .eq("pro_id", entity.getProId())
            .eq("vehicle_type", entity.getVehicleType()));
        }
    }
}
