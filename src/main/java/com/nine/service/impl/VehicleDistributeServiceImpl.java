package com.nine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.entity.TrafficParaEntity;
import com.nine.entity.VehicleTypeDistributionEntity;
import com.nine.mapper.VehicleDistributeMapper;
import com.nine.service.VehicleDistributeService;
import com.nine.vo.VehicleTypeDisVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VehicleDistributeServiceImpl extends ServiceImpl<VehicleDistributeMapper, VehicleTypeDistributionEntity> implements VehicleDistributeService {
    @Override
    public VehicleTypeDistributionEntity getByProId(int proid) {
        if(StringUtils.checkValNotNull(proid)){
            VehicleTypeDistributionEntity distributionEntity = this.getOne(new QueryWrapper<VehicleTypeDistributionEntity>().eq("pro_id", proid));
            return distributionEntity;
        }
        return null;
    }

    @Override
    public VehicleTypeDistributionEntity getByProIdAndLevelTtc(VehicleTypeDisVo vo) {
        LambdaQueryWrapper<VehicleTypeDistributionEntity> wrapper = new LambdaQueryWrapper<>();
        // 获取项目ID信息，默认是0
        Integer proId = 0;
        if(StringUtils.checkValNotNull(vo.getProId())){
            proId = vo.getProId();
            wrapper.eq(VehicleTypeDistributionEntity::getProId, proId);
        }
        // 获取水平信息，默认是水平一/二
        Integer level = 0;
        if(StringUtils.checkValNotNull(vo.getLevel())){
            level = vo.getLevel();
            wrapper.eq(VehicleTypeDistributionEntity::getLevel, level);
        }
        // 获取水平信息，默认是TTC1
        Integer ttc = 1;
        // 只有水平三（level=1）时，才有这里的TTC区别
        if(level.equals(1) && StringUtils.checkValNotNull(vo.getTtc())){
            ttc = vo.getTtc();
            wrapper.eq(VehicleTypeDistributionEntity::getTtc, ttc);
        }
        // 获取车辆类型分布参数
        VehicleTypeDistributionEntity distributionEntity = this.getOne(wrapper);
        return distributionEntity;
    }

    @Override
    public void updateByProIdAndLevel(VehicleTypeDistributionEntity distributionEntity) {
        this.update(distributionEntity,new UpdateWrapper<VehicleTypeDistributionEntity>().eq("pro_id", distributionEntity.getProId()).eq("level", distributionEntity.getLevel()));
    }
}
