package cn.codingstar.offer.proxy.bean.impl;

import cn.codingstar.offer.proxy.bean.UserService;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: UserServiceImpl.java
 * @time: 18-3-15 下午5:08
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加用户");
    }
}
