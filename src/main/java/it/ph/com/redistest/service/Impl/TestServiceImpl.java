package it.ph.com.redistest.service.Impl;

import it.ph.com.redistest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author PH
 * @时间： 2022/11/7
 * @描述：
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public void groupingTest() {
        redisTemplate.opsForValue().set("TEST:uuu", 4454);
        System.out.println("有没有报错！");

    }

    @Override
    public Object getGroupingData() {
        Object data = redisTemplate.opsForValue().get("TEST:uuu");
        System.out.println(data);
        return data;
    }

    @Override
    public Object deleteData(String key) {
        Boolean delete = redisTemplate.delete(key);
        System.out.println(delete);
        return delete;
    }
}
