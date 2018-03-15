package cn.codingstar.offer.proxy.cglib;

import cn.codingstar.offer.proxy.bean.UserService;
import cn.codingstar.offer.proxy.bean.impl.UserServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: App.java
 * @time: 18-3-15 下午6:54
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class App {

    public static void main(String[] args) {
        // 生成代理保存在本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "proxy");
        // 创建被代理对象
        UserService userService = new UserServiceImpl();
        // 创建CglibProxy对象
        CglibProxy cp = new CglibProxy();
        // 创建代理对象
        UserServiceImpl proxy = (UserServiceImpl) cp.getProxy(userService.getClass());
        // 调用方法
        proxy.add();
    }

}
