package com.nine.controller;

import com.nine.common.utils.R;
import com.nine.entity.TrafficParaEntity;
import com.nine.entity.VehicleProportionEntity;
import com.nine.service.VehiclePropotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiclepro")
public class VehiclePropotionController {
    @Autowired
    VehiclePropotionService vehiclePropotionService;

    /**
     * 根据项目id获取该项目下的车型比例信息
     * @param proid // url中附带的项目id
     * @return
     */
    // http://localhost:8080/vehiclepro/list/1
    @GetMapping("/list/{proid}")
    public R list(@PathVariable("proid") int proid){
        List<VehicleProportionEntity> entities = vehiclePropotionService.getByProId(proid);

        return R.success(entities);
    }

    /**
     * 需要保存两条数据，分别是非满载车和满载车的不同比例
     * @param entities
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody List<VehicleProportionEntity> entities){
        vehiclePropotionService.saveBatch(entities);

        return R.success(null);
    }
    /**
     * 修改一个list列表
     * @param entities
     * @return
     */
    @PutMapping("/update")
    public R update(@RequestBody List<VehicleProportionEntity> entities){
        vehiclePropotionService.updateByProIdAndType(entities);

        return R.success(null);
    }
}
