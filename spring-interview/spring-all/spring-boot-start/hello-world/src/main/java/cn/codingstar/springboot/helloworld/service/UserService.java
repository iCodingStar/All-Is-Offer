package cn.codingstar.springboot.helloworld.service;

import cn.codingstar.springboot.helloworld.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: UserService.java
 * @time: 2018/2/27 10:36
 * @software: Intellij Idea
 * @desc:
 */
@Service
public class UserService {

    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        User star = new User();
        star.setName("Star");
        star.setAge(25);
        star.setPassword("xxxxxxxxxx");
        list.add(star);
        return list;
    }

    public User getUser() {
        User star = new User();
        star.setName("Star");
        star.setAge(25);
        star.setPassword("xxxxxxxxxx");
        return star;
    }
}
