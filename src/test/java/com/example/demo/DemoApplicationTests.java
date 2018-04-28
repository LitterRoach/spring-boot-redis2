package com.example.demo;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
        //如何使用RedisTemplate访问Redis数据结构
        //https://www.jianshu.com/p/7bf5dc61ca06
        SetOperations<String, Object> op = redisTemplate.opsForSet();
        op.add("setData", Lists.newArrayList("java", "c++").toArray());
        System.out.println(op.members("setData"));
    }
}
