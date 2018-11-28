package com.xun.tigablog.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("/").hasRole("USER");

        //开启自动配置登录功能，如果没登录则来到登录页面
        http.formLogin().loginPage("/login").defaultSuccessUrl("/", true);

        //自动配置注销功能
        http.logout();

        //开启记住我
        http.rememberMe();
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().withUser("wangxun").password("123456").roles("USER", "ADMIN");
    }
}
