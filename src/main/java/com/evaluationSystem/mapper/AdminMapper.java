package com.evaluationSystem.mapper;

import com.evaluationSystem.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【evaluation_system_admin】的数据库操作Mapper
* @createDate 2024-03-29 16:50:58
* @Entity com.evaluationSystem.domain.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    Admin getOneByUserId(String userId);

}




