package com.xun.tigablog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public String getTest() {
        return "hello TIGA!";
    }

    @ResponseBody
    @GetMapping("/testdb")
    public Map<String, Object> getDataFromDB() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from test");
        return list.get(0);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String index() {
        return "dashboard";
    }
}
