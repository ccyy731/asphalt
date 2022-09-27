package com.nine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nine.entity.VehicleProportionEntity;

import java.util.List;

public interface VehiclePropotionService extends IService<VehicleProportionEntity> {
    List<VehicleProportionEntity> getByProId(int proid);

    void updateByProIdAndType(List<VehicleProportionEntity> entities);
}
