package com.evaluationSystem.controller;

import com.evaluationSystem.domain.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * description
 *
 * @author admin 2024/04/02 14:46
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/toLogin")
    public String hello() {
        return "LOGIN";
    }
    @RequestMapping("/check")
    public Result<Void> check(){
        return Result.error();
    }
    @RequestMapping("/success")
    public Result<Void> success(){
        return Result.success();
    }
    @RequestMapping("/error")
    public Result<Void> error(){
        return Result.error("登录失败");
    }

    /**
     * 跳转管理员登录界面
     * @return
     */
    @RequestMapping("/loginForAdmin")
    public ModelAndView loginForAdmin(){
        return new ModelAndView("/login/loginForAdmin");
    }

}

