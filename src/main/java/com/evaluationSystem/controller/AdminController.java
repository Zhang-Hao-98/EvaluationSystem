package com.evaluationSystem.controller;

import com.evaluationSystem.domain.result.Result;
import com.evaluationSystem.service.AdminService;
import com.evaluationSystem.service.impl.AdminServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * description
 *
 * @author admin 2023/12/04 14:29
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminService adminService = new AdminServiceImpl();


    /**
     * 跳转管理员登录界面
     * @return
     */
    @RequestMapping("/loginForAdmin")
    public String loginForAdmin(){
       return "/loginForAdmin";
    }

    /**
     * 管理员登录验证
     * */
    @ResponseBody
    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public Result adminLoginCheck(String account, String password, HttpServletRequest request, HttpServletResponse response) {
        return adminService.searchByUserIdAndPassword(account,password);
    }



}

