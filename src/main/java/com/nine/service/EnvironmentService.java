package com.nine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nine.entity.EnvironmentEntity;


public interface EnvironmentService extends IService<EnvironmentEntity> {
    EnvironmentEntity getByProId(int proid);
}
