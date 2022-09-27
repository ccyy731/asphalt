package com.nine.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nine.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeEntity> {
}
