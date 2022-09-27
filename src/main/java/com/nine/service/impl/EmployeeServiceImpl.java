package com.nine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nine.entity.EmployeeEntity;
import com.nine.mapper.EmployeeMapper;
import com.nine.service.EmployeeService;
import org.springframework.stereotype.Service;

//@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {
}
