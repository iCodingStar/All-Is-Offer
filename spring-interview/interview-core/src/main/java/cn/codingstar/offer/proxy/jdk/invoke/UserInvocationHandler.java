package cn.codingstar.offer.proxy.jdk.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: UserInvocationHandler.java
 * @time: 18-3-15 下午5:09
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class UserInvocationHandler implements InvocationHandler {

    private Object target;

    public UserInvocationHandler(Object object) {
        super();
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------------begin " + method.getName() + "-----------------");
        Object result = method.invoke(target, args);
        System.out.println("-----------------end " + method.getName() + "-----------------");
        return result;
    }

    /**
     * 通过Proxy类来获取动态代理的对象
     *
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}
