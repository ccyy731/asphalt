package com.nine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nine.common.utils.R;
import com.nine.entity.ProjectInfoEntity;
import com.nine.entity.StructuralEntity;
import com.nine.entity.VehicleProportionEntity;
import com.nine.service.StructuralService;
import com.nine.vo.StructuralInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/structural")
public class StructuralController {

    @Autowired
    StructuralService structuralService;


    /**
     * 根据项目id获取该项目下各层结构的列表
     * @param proid // url中附带的项目id
     * @return
     */
    // http://localhost:8080/structural/list/1
    @GetMapping("/list/{proid}")
    public R list(@PathVariable("proid") int proid){
        List<StructuralEntity> entities = structuralService.getBatchByProId(proid);

        return R.success(entities);
    }

    /**
     * 点击增加弹框中的保存按钮触发
     * 前端除了给表单提交的数据外还需要给出当前的proid
     * @param structuralEntity
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody StructuralEntity structuralEntity){
        structuralService.save(structuralEntity);

        return R.success(null);
    }

    /**
     * 点击编辑按钮时需要先根据结构表的id进行查询，查出结构信息和相关材料数据的vo后返回数据进行回显
     */
    // http://localhost:8080/structural/info/1
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") int id){
        // 这里返回一个vo，包含结构和材料信息
        StructuralInfoVo vo = structuralService.getInfoById(id);
        return R.success(vo);
    }

    /**
     * 编辑修改，点击编辑里的保存按钮触发
     */
    // http://localhost:8080/structural/update
    @PutMapping("/update")
    public R update(@RequestBody StructuralInfoVo infoVo){

        // 接受前端给的vo，然后把信息都保存到结构和材料两个表中
        structuralService.updateInfoVo(infoVo);

        return R.success(null);
    }


    /**
     * 批量删除，需要删除材料表和结构表的信息
     * @param ids 结构id组成的数组
     * @return
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        structuralService.removeStructuralMaterialByIds(Arrays.asList(ids));

        return R.success(null);
    }

}
