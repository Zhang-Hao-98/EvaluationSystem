package com.evaluationSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evaluationSystem.domain.Admin;
import com.evaluationSystem.domain.result.Result;
import com.evaluationSystem.service.AdminService;
import com.evaluationSystem.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【evaluation_system_admin】的数据库操作Service实现
* @createDate 2023-12-04 16:43:22
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Result searchByUserIdAndPassword(String user_id, String password) {
        try {
            Admin admin = adminMapper.selectByIdAndPassword(user_id, password);
            if (admin == null) {
                return Result.error("账号不存在");
            } else if (admin.getUse_status() == 0) {
                return Result.error("账号被禁用");
            } else {
                return Result.success();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




