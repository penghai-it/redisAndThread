package it.ph.com.redistest.service.Impl;

import it.ph.com.redistest.RedisTestApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author PH
 * @时间： 2022/11/7
 * @描述：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisTestApplication.class)
class TestServiceImplTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void groupingTest() {
        redisTemplate.opsForValue().set("TEST:test2", 23456);
    }

    @Test
    void getGroupingData() {
    }

    @Test
    void deleteData() {
    }
}