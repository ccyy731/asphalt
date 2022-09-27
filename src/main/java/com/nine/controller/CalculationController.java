package com.nine.controller;

import com.nine.common.utils.R;
import com.nine.utils.calculatin.StressAndStrainCalculation;
import com.nine.vo.StressAndStrainCalcalationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
/**
 * 应力应变计算模块
 */

@Slf4j
@RestController
@RequestMapping("/calculation")
public class CalculationController {

    /**
     * 应力应变计算功能的调用
     * @param vo 前端返回的用于进行应力应变计算的Vo数据
     * @return
     */
    @PostMapping("/sas")
    public R stressAndStrain(@RequestBody StressAndStrainCalcalationVo vo){

        try{
            // 应力应变计算
            String cmd = "\"D:\\graduate\\group\\项目\\应力应变计算相关资料\\应力应变计算\\Apbi层状体系计算程序6位.exe\"";
            StressAndStrainCalculation sas = new StressAndStrainCalculation();

            // 按照指定格式写一个用于计算的输入文件Apbidat
            sas.writeFile(vo);
            // 根据输入文件调用程序进行计算
            sas.calculation(cmd);

            // 读出结果文件内容，并返回给前端进行显示
            // 由于生成的结果文件是ansi编码格式，因此需要转为gbk格式避免中文乱码
            sas.readByBufferedReader("gbk");

            return R.success(null);
        }catch (Exception e){
            log.error(e.getMessage());
            return R.error(e.getMessage());
        }

    }
}
