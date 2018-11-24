package com.xun.tigablog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public String getTest(){
        return "hello TIGA!";
    }

    @ResponseBody
    @GetMapping("/testdb")
    public Map<String, Object> getDataFromDB(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from test");
        return list.get(0);
    }

}
