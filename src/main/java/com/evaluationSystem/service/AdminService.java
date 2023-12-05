package com.evaluationSystem.service;

import com.evaluationSystem.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evaluationSystem.domain.result.Result;
import com.evaluationSystem.mapper.AdminMapper;
import jakarta.annotation.Resource;

/**
* @author admin
* @description 针对表【evaluation_system_admin】的数据库操作Service
* @createDate 2023-12-04 16:43:22
*/
public interface AdminService extends IService<Admin> {

    /**
     * 管理员账号查询
     * @param user_id
     * @param password
     * @return
     */
    Result searchByUserIdAndPassword(String user_id, String password);

}
