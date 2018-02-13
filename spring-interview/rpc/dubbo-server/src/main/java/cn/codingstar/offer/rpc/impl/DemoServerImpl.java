package cn.codingstar.offer.rpc.impl;

import cn.codingstar.offer.rpc.DemoServer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: DemoServerImpl.java
 * @time: 2018/2/13 14:47
 * @software: Intellij Idea
 * @desc:
 */
public class DemoServerImpl implements DemoServer {
    @Override
    public String sayHello(String str) {
        str = "Hello " + str + " " + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return str;
    }
}
