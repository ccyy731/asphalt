package com.nine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nine.entity.VehicleTypeDistributionEntity;
import com.nine.vo.VehicleTypeDisVo;


public interface VehicleDistributeService extends IService<VehicleTypeDistributionEntity> {
    VehicleTypeDistributionEntity getByProId(int vo);

    VehicleTypeDistributionEntity getByProIdAndLevelTtc(VehicleTypeDisVo vo);

    void updateByProIdAndLevel(VehicleTypeDistributionEntity distributionEntity);
}
