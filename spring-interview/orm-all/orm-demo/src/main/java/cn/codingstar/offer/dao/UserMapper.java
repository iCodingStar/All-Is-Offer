package cn.codingstar.offer.dao;

import cn.codingstar.offer.entity.User;

import java.util.List;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: UserMapper.java
 * @time: 18-3-25 下午6:48
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public interface UserMapper {

    void insert(User user);

    User findUserById(int userId);

    List<User> findAllUsers();

}
