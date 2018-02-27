package cn.codingstar.springboot.helloworld.domain;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: User.java
 * @time: 2018/2/27 10:35
 * @software: Intellij Idea
 * @desc:
 */
public class User {

    private String name;

    private Integer age;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
