package com.evaluationSystem.mapper;

import com.evaluationSystem.domain.Roles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【evaluation_system_roles】的数据库操作Mapper
* @createDate 2024-03-29 16:51:08
* @Entity com.evaluationSystem.domain.Roles
*/
@Mapper
public interface RolesMapper extends BaseMapper<Roles> {
    List<Roles> getAllByUserId(String userId);

}




