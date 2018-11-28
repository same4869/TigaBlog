package com.xun.tigablog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcWebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/tigablog").setViewName("success");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/dashboard").setViewName("dashboard");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
                registry.addViewController("/list").setViewName("list");
                registry.addViewController("/404").setViewName("404");
            }
        };
        return adapter;
    }
}
