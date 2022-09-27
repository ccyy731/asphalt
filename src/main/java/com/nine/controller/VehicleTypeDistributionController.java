package com.nine.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.nine.common.utils.R;
import com.nine.entity.VehicleProportionEntity;
import com.nine.entity.VehicleTypeDistributionEntity;
import com.nine.service.VehicleDistributeService;
import com.nine.vo.VehicleTypeDisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleTypeDistributionController {

    @Autowired
    VehicleDistributeService vehicleDistributeService;

    //TODO 单独查询车辆分布系数表的内容

    /**
     * 根据项目id以及水平和不同的ttc获取该项目下的交通参数信息
     * @param vo
     * @return
     */
    // http://localhost:8080/vehicle/info
    @PostMapping("/info")
    public R info(@RequestBody VehicleTypeDisVo vo){
        VehicleTypeDistributionEntity entity = vehicleDistributeService.getByProIdAndLevelTtc(vo);

        return R.success(entity);
    }

    /**
     * 前端除了给表单提交的数据外还需要给出当前的proid
     * @param vehicleTypeDistributionEntity
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody VehicleTypeDistributionEntity vehicleTypeDistributionEntity){
        vehicleDistributeService.save(vehicleTypeDistributionEntity);

        return R.success(null);
    }
    /**
     * 修改
     * @param distributionEntity
     * @return
     */
    @PutMapping("/update")
    public R update(@RequestBody VehicleTypeDistributionEntity distributionEntity){
        vehicleDistributeService.updateByProIdAndLevel(distributionEntity);

        return R.success(null);
    }
}
