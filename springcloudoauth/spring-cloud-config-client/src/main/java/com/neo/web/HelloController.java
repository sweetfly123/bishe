package com.neo.web;

import com.neo.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
class HelloController {

    @Resource
    public UserDao userDao;
    @Value("${name}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        String pa =  userDao.getpass("aa");
        return pa;
    }
}