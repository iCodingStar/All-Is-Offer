package cn.codingstar.offer.example;

import redis.clients.jedis.Jedis;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: JedisClient.java
 * @time: 18-4-23 下午10:06
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class JedisClient {

    private static class User {
        private String username = "star";
        private String password = "pwd";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("连接成功");
        String info = jedis.info("memory");
        System.out.println(info);
    }
}
