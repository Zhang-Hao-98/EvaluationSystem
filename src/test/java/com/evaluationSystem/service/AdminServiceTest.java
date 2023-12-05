package com.evaluationSystem.service;

import com.evaluationSystem.domain.Admin;
import com.evaluationSystem.domain.result.Result;
import com.evaluationSystem.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.Assert;


import static org.junit.jupiter.api.Assertions.*;

/**
 * description
 *
 * @author admin 2023/12/04 17:19
 */
class AdminServiceTest {

    @Resource
    private AdminService adminService;

    @Test
    void searchByUserIdAndPassword() {
        Result result = adminService.searchByUserIdAndPassword("20230510","23232323");
        System.out.println("result: " + result);
        Assert.assertTrue("查询不到admin",result.getCode() == 200);
    }
}