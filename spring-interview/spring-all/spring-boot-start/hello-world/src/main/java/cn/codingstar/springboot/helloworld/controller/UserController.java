package cn.codingstar.springboot.helloworld.controller;

import cn.codingstar.springboot.helloworld.domain.User;
import cn.codingstar.springboot.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: UserController.java
 * @time: 2018/2/27 10:36
 * @software: Intellij Idea
 * @desc:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getUserList() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/user",produces = "application/json")
    public User getUser() {
        return userService.getUser();
    }
}
