package cn.codingstar.offer.proxy.jdk;

import cn.codingstar.offer.proxy.bean.UserService;
import cn.codingstar.offer.proxy.bean.impl.UserServiceImpl;
import cn.codingstar.offer.proxy.jdk.invoke.UserInvocationHandler;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: App.java
 * @time: 18-3-15 下午5:15
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class App {

    public static void main(String[] args) {
        // 生成的代理类保存到磁盘
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 创建被代理实例
        UserService userService = new UserServiceImpl();
        // 获取handler
        UserInvocationHandler handler = new UserInvocationHandler(userService);
        // 获取代理对象
        UserService proxy = (UserService) handler.getProxy();
        // 用代理调用目标方法
        proxy.add();
    }
}
