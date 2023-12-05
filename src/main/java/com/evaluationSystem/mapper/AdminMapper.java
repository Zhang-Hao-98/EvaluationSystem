package com.evaluationSystem.mapper;

import com.evaluationSystem.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author admin
* @description 针对表【evaluation_system_admin】的数据库操作Mapper
* @createDate 2023-12-04 16:43:22
* @Entity com.evaluationSystem.domain.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    Admin selectByIdAndPassword(String user_id, String password);
}




