package com.nine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nine.entity.EalfEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EalfService extends IService<EalfEntity> {
    List<EalfEntity> getByProId(int proid, int index);

    void updateByProIdAndIndicator(List<EalfEntity> ealfEntities);
}
