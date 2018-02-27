package cn.codingstar.springboot.helloworld.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: BaseService.java
 * @time: 2018/2/27 9:41
 * @software: Intellij Idea
 * @desc:
 */
@Service
@EnableAutoConfiguration
public class BaseService {

    public String hello() {
        return "Hello World";
    }

}
