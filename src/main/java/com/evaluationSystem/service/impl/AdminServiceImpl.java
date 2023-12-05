package com.evaluationSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evaluationSystem.domain.Admin;
import com.evaluationSystem.mapper.AdminMapper;
import com.evaluationSystem.service.AdminService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author admin 2024/04/02 17:11
 */
@Service("AdminService")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService{

}

