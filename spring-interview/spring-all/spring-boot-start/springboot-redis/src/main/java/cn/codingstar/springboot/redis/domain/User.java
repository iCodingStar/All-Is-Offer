package cn.codingstar.springboot.redis.domain;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: User.java
 * @time: 2018/2/27 13:03
 * @software: Intellij Idea
 * @desc:
 */
public class User {

    private String name;

    private Integer age;

    private String email;

    public User() {
    }

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
