package com.nine.controller;

import com.nine.common.utils.R;
import com.nine.entity.EalfEntity;
import com.nine.service.EalfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ealf")
public class EalfController {

    @Autowired
    EalfService ealfService;

    /**
     * 根据项目id和控制指标获取该项目下的ealf信息，这里的一个控制指标最多会有两条数据（满载车和非满载车的）
     * @param proid // url中附带的项目id
     * @return
     */
    // http://localhost:8080/ealf/list/1/2
    @GetMapping("/list/{proid}/{conIndex}")
    public R list(@PathVariable("proid") int proid, @PathVariable("conIndex") int index){
        List<EalfEntity> entities = ealfService.getByProId(proid, index);

        return R.success(entities);
    }
    /**
     * 需要保存两条数据，分别是非满载车和满载车的不同轴载换算系数
     * @param entities
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody List<EalfEntity> entities){
        ealfService.saveBatch(entities);

        return R.success(null);
    }

    /**
     * 修改一个list列表
     * @param ealfEntities
     * @return
     */
    @PutMapping("/update")
    public R update(@RequestBody List<EalfEntity> ealfEntities){
        ealfService.updateByProIdAndIndicator(ealfEntities);

        return R.success(null);
    }
}
