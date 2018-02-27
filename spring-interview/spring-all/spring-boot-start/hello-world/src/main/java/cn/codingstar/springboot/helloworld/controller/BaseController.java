package cn.codingstar.springboot.helloworld.controller;

import cn.codingstar.springboot.helloworld.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: BaseController.java
 * @time: 2018/2/27 9:39
 * @software: Intellij Idea
 * @desc:
 */
@RestController
@EnableAutoConfiguration
public class BaseController {

    @Autowired
    private BaseService baseService;

    @RequestMapping("/hello")
    String home() {
        return baseService.hello();
    }
}
