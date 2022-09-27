package com.nine.controller;

import com.nine.common.utils.PageUtils;
import com.nine.common.utils.R;
import com.nine.entity.ProjectInfoEntity;
import com.nine.entity.TrafficParaEntity;
import com.nine.service.ProjectInfoService;
import com.nine.utils.calculatin.StressAndStrainCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/projectInfo")
public class ProjectInfoController {

    @Autowired
    ProjectInfoService projectInfoService;

    /**
     * 显示项目管理中的项目列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectInfoService.queryPage(params);

        return R.success(page);
    }
    /**
     * 根据项目id获取该项目下的交通参数信息
     * @param id // url中附带的项目id
     * @return
     */
    // http://localhost:8080/projectInfo/getByProId/1
    @GetMapping("/getByProId/{proid}")
    public R getByProId(@PathVariable("proid") int id){
        ProjectInfoEntity entity = projectInfoService.getByProId(id);

        return R.success(entity);
    }

    /**
     * 保存新建项目
     */
    @PostMapping("/save")
    public R save(@RequestBody ProjectInfoEntity projectInfoEntity){
        projectInfoService.save(projectInfoEntity);

        return R.success(null);
    }
    /**
     * 根据id和搜索框的key值查询项目信息
     * params包含的数据：
     *  id      // 查询的id
     *  key     // 查询的关键字
     */
    @GetMapping("/info")
    public R queryByCondition(@RequestParam Map<String, Object> params){
        PageUtils page = projectInfoService.queryByCondition(params);

        return R.success(page);
    }
    /**
     * 编辑修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ProjectInfoEntity projectInfoEntity){
        projectInfoService.updateByIdDetail(projectInfoEntity);

        return R.success(null);
    }

    /**
     * 删除
     * @param id    // 要删除的id
     * @return
     */
    @DeleteMapping("/delete")
    public R delete(@RequestParam int id){
        projectInfoService.removeById(id);

        return R.success(null);
    }
}
