package com.xun.tigablog.controller;

import com.xun.tigablog.domain.Authority;
import com.xun.tigablog.domain.User;
import com.xun.tigablog.service.AuthorityService;
import com.xun.tigablog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    private static final Long ROLE_USER_AUTHORITY_ID = 2L;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService  authorityService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/blogs";
    }

    /**
     * 获取登录界面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 注册用户
     * @param user
     * @param result
     * @param redirect
     * @return
     */
    @PostMapping("/register")
    public String registerUser(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

}
