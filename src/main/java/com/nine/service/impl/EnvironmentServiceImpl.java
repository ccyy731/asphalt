package com.nine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.entity.EnvironmentEntity;
import com.nine.entity.TrafficParaEntity;
import com.nine.mapper.EnvironmentMapper;
import com.nine.service.EnvironmentService;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentServiceImpl extends ServiceImpl<EnvironmentMapper, EnvironmentEntity> implements EnvironmentService {
    @Override
    public EnvironmentEntity getByProId(int proid) {
        if(StringUtils.checkValNotNull(proid)){
            EnvironmentEntity environmentEntity = this.getOne(new QueryWrapper<EnvironmentEntity>().eq("pro_id", proid));
            return environmentEntity;
        }
        return null;
    }
}
