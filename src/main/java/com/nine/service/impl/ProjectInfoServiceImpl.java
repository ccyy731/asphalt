package com.nine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nine.common.utils.PageUtils;
import com.nine.common.utils.Query;
import com.nine.entity.ProjectInfoEntity;
import com.nine.entity.TrafficParaEntity;
import com.nine.mapper.ProjectInfoMapper;
import com.nine.service.ProjectInfoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProjectInfoServiceImpl extends ServiceImpl<ProjectInfoMapper, ProjectInfoEntity> implements ProjectInfoService {
    @Override
    public PageUtils queryByCondition(Map<String, Object> params) {
        QueryWrapper<ProjectInfoEntity> wrapper = new QueryWrapper<>();

        String id = (String) params.get("id");
        if(StringUtils.checkValNotNull(id) && !"0".equalsIgnoreCase(id)){
            wrapper.eq("id", id);
        }
        String key = (String) params.get("key");
        if(StringUtils.checkValNotNull(key)){
            wrapper.and(w->{
                w.like("project_filename", key).or().like("project_name", key);
            });
        }

        IPage<ProjectInfoEntity> page = this.page(new Query<ProjectInfoEntity>().getPage(params), wrapper);

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProjectInfoEntity> page = this.page(
                new Query<ProjectInfoEntity>().getPage(params),
                new QueryWrapper<ProjectInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void updateByIdDetail(ProjectInfoEntity projectInfoEntity) {
        this.updateById(projectInfoEntity);
        // TODO 如有关联到其他表，则也需更新
    }

    @Override
    public ProjectInfoEntity getByProId(int id) {
        if(StringUtils.checkValNotNull(id)){
            ProjectInfoEntity projectInfoEntity = this.getOne(new QueryWrapper<ProjectInfoEntity>().eq("id", id));
            return projectInfoEntity;
        }
        return null;
    }

}
