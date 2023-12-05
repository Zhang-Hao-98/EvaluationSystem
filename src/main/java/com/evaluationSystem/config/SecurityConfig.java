package com.evaluationSystem.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity    // 添加 security 过滤器
public class SecurityConfig {


    /**
     * 配置密码编辑器
     * @author  zhang hao
     * @date    2024/4/2-14:23     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义登录角色 而不是默认用户
     * @author  admin
     * @date    2024/4/2-13:53
     */
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        // 使用密码编码器对密码进行编码
//        String encodedPassword = passwordEncoder().encode("admin");
//        userDetailsManager.createUser(User.withUsername("admin").password(encodedPassword).roles("ADMIN").build());
//        return userDetailsManager;
//    }

    /**
     * 自定义Spring Security的配置
     * @author  zhang hao
     * @date    2024/4/2-14:34     */
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        // 忽略login路径下的安全配置 这样设置会导致默认登录设置失败
//        return (web) ->  web.ignoring().requestMatchers("/login/**");
//    }


    /**
     * 用于配置安全过滤器链的接口
     * @param http
     * @throws Exception
     * @author  zhang hao
     * @date    2024/4/2-14:32     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               // 配置请求的授权规则
               .authorizeHttpRequests(authorizeHttpRequests  ->
                       authorizeHttpRequests
                               // public 路径下的访问不需要验证身份
                               .requestMatchers("/public/**").permitAll()
                               .requestMatchers("/login/**").permitAll()
                               // admin 路径下需要 ADMIN 角色
                               .requestMatchers("/admin/**").hasRole("ADMIN")
                               // user 路径下需要USER 角色
                               .requestMatchers("/user/**").hasRole("USER")
                               // 其他请求都需要验证身份
                               .anyRequest().authenticated()
                       )
               // 配置 Spring Security 的表单登录功能
               .formLogin(formLogin ->
                       formLogin
                               // 配置默认登录页面
                               .loginPage("/login/loginForAdmin")
                                // 登录页面提交表单的请求处理
                               .loginProcessingUrl("/login/login")
                               // 设置参数名称
                               .usernameParameter("username")
                               .passwordParameter("password")
                               .successForwardUrl("/login/success")
                               .failureUrl("/login/error")
               )
               //关闭csrf防护
               .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     * @param auth
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    /**
     * 配置跨源访问(CORS)
     * @return
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

