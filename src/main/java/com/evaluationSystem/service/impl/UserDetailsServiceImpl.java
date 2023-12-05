package com.evaluationSystem.service.impl;

import com.evaluationSystem.domain.Admin;
import com.evaluationSystem.domain.Roles;
import com.evaluationSystem.mapper.AdminMapper;
import com.evaluationSystem.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author admin 2024/04/02 16:51
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * 需新建配置类注册一个指定的加密方式Bean，或在下一步Security配置类中注册指定
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RolesMapper rolesMapper;

    /**
     * 根据用户名登录
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminMapper.getOneByUserId(username);
        if (admin == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 得到用户角色
        List<Roles> roles = rolesMapper.getAllByUserId(username);

        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Roles role : roles) {
            // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
            authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }


        return new User(
                admin.getUserId(),
                // 因为数据库是明文，所以这里需加密密码
                passwordEncoder.encode(admin.getPassword()),
                authorities
        );
    }
}

