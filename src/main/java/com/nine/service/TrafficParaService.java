package com.nine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nine.entity.TrafficParaEntity;
import com.nine.vo.GeneralTrafficParamsVo;
import com.nine.vo.VehicleTypeDisVo;


public interface TrafficParaService extends IService<TrafficParaEntity> {
    TrafficParaEntity getByProId(int proid);

    GeneralTrafficParamsVo getGeneralTrafficParams(VehicleTypeDisVo vo);
}
