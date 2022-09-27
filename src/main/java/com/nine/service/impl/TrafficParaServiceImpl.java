package com.nine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.entity.TrafficParaEntity;
import com.nine.entity.VehicleTypeDistributionEntity;
import com.nine.mapper.TrafficParaMapper;
import com.nine.service.TrafficParaService;
import com.nine.service.VehicleDistributeService;
import com.nine.vo.GeneralTrafficParamsVo;
import com.nine.vo.VehicleTypeDisVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrafficParaServiceImpl extends ServiceImpl<TrafficParaMapper, TrafficParaEntity> implements TrafficParaService {

    @Autowired
    VehicleDistributeService distributeService;

    @Override
    public TrafficParaEntity getByProId(int proid) {
        if(StringUtils.checkValNotNull(proid)){
            TrafficParaEntity trafficParaEntity = this.getOne(new QueryWrapper<TrafficParaEntity>().eq("pro_id", proid));
            return trafficParaEntity;
        }
        return null;
    }

    @Override
    public GeneralTrafficParamsVo getGeneralTrafficParams(VehicleTypeDisVo vo) {
        GeneralTrafficParamsVo generalTrafficParamsVo = new GeneralTrafficParamsVo();

        LambdaQueryWrapper<VehicleTypeDistributionEntity> wrapper = new LambdaQueryWrapper<>();
        // 获取项目ID信息，默认是0
        Integer proId = 0;
        if(StringUtils.checkValNotNull(vo.getProId())){
            proId = vo.getProId();
            wrapper.eq(VehicleTypeDistributionEntity::getProId, proId);
        }
        // 获取交通参数
        TrafficParaEntity trafficParaEntity = this.getByProId(proId);
        BeanUtils.copyProperties(trafficParaEntity, generalTrafficParamsVo);

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
        VehicleTypeDistributionEntity distributionEntity = distributeService.getOne(wrapper);

        BeanUtils.copyProperties(distributionEntity, generalTrafficParamsVo);

        return generalTrafficParamsVo;
    }
}
