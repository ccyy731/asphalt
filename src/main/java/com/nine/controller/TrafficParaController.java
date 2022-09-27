package com.nine.controller;

import com.nine.common.utils.R;
import com.nine.entity.EalfEntity;
import com.nine.entity.TrafficParaEntity;
import com.nine.service.TrafficParaService;
import com.nine.vo.GeneralTrafficParamsVo;
import com.nine.vo.VehicleTypeDisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traffic")
public class TrafficParaController {

    @Autowired
    TrafficParaService trafficParaService;

    /**
     * 获取一般交通参数和车辆类型分布系数，这里需要查找两个表的信息
     * @param vo
     * @return
     */
    // http://localhost:8080/traffic/params
    @GetMapping("/params")
    public R generalTrafficParams(@RequestBody VehicleTypeDisVo vo){
        GeneralTrafficParamsVo params = trafficParaService.getGeneralTrafficParams(vo);

        return R.success(params);
    }


    /**
     * 根据项目id获取该项目下的交通参数信息
     * @param proid // url中附带的项目id
     * @return
     */
    // http://localhost:8080/traffic/list/1
    @GetMapping("/list/{proid}")
    public R list(@PathVariable("proid") int proid){
        TrafficParaEntity entity = trafficParaService.getByProId(proid);

        return R.success(entity);
    }

    /**
     * 前端除了给表单提交的数据外还需要给出当前的proid
     * @param trafficParaEntity
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody TrafficParaEntity trafficParaEntity){
        trafficParaService.save(trafficParaEntity);

        return R.success(null);
    }
    /**
     * 修改
     * @param trafficParaEntity
     * @return
     */
    @PutMapping("/update")
    public R update(@RequestBody TrafficParaEntity trafficParaEntity){
        trafficParaService.updateById(trafficParaEntity);

        return R.success(null);
    }
}
