package com.nine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.entity.StructuralMaterialEntity;
import com.nine.mapper.StructuralMaterialMapper;
import com.nine.service.StructuralMaterialService;
import org.springframework.stereotype.Service;

@Service
public class StructuralMaterialServiceImpl extends ServiceImpl<StructuralMaterialMapper, StructuralMaterialEntity> implements StructuralMaterialService {
}
