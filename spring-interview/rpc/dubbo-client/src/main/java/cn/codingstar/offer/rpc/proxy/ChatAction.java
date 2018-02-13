package cn.codingstar.offer.rpc.proxy;

import cn.codingstar.offer.rpc.DemoServer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: ChatAction.java
 * @time: 2018/2/13 16:00
 * @software: Intellij Idea
 * @desc:
 */
public class ChatAction {

    public void sayHello() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        // 根据java bean的名字获取java bean实例
        DemoServer server = (DemoServer) context.getBean("demoService");
        System.out.println("client:" + server.sayHello("zx" + "1:" + new Date()) + "3:" + new Date());
    }
}
