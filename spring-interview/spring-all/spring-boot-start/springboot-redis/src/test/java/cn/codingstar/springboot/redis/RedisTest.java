package cn.codingstar.springboot.redis;

import cn.codingstar.springboot.redis.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: RedisTest.java
 * @time: 2018/2/27 12:39
 * @software: Intellij Idea
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals(stringRedisTemplate.opsForValue().get("aaa"), "111");
    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User("star", 24, "shixing.cs@gmail.com");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 100, TimeUnit.SECONDS);
        Thread.sleep(5000);
        boolean exist = redisTemplate.hasKey("com.neo.f");
        if (exist) {
            System.out.printf("true");
        } else {
            System.out.printf("false");
        }
        Assert.assertEquals(operations.get("com.neo.f").getName(), "star");
    }
}
