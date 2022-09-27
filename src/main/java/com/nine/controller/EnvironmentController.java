package com.nine.controller;

import com.nine.common.utils.R;
import com.nine.entity.EalfEntity;
import com.nine.entity.EnvironmentEntity;
import com.nine.entity.TrafficParaEntity;
import com.nine.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

    @Autowired
    EnvironmentService environmentService;

    /**
     * 根据项目id和控制指标获取该项目下的环境参数
     * @param proid
     * @return
     */
    // http://localhost:8080/ealf/list/1
    @GetMapping("/list/{proid}")
    public R list(@PathVariable("proid")int proid){
        EnvironmentEntity entity = environmentService.getByProId(proid);

        return R.success(entity);
    }
    /**
     * 保存，前端除了给表单提交的数据外还需要给出当前的proid
     * @param environmentEntity
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody EnvironmentEntity environmentEntity){
        environmentService.save(environmentEntity);

        return R.success(null);
    }
    /**
     * 修改
     * @param environmentEntity
     * @return
     */
    @PutMapping("/update")
    public R update(@RequestBody EnvironmentEntity environmentEntity){
        environmentService.updateById(environmentEntity);

        return R.success(null);
    }
}
