package it.ph.com.redistest.controller;

import it.ph.com.redistest.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PH
 * @时间： 2022/9/27
 * @描述：
 */
@RestController
@RequestMapping("redis")
public class RedisTestController {
    @Autowired
    RedisTestService redisTestService;

    @GetMapping("/test")
    public boolean set(@RequestParam("key") String key, @RequestParam("value") Long value) {
        return redisTestService.set(key, value);
    }

    @GetMapping("/test1")
    public boolean hsets(@RequestParam("key") String key, @RequestParam("item") String item, @RequestParam("value") Long value) {
        return redisTestService.hset(key, item, value);
    }

    @GetMapping("/test2")
    public boolean expire(@RequestParam("key") String key, @RequestParam("time") long time) {
        return redisTestService.expire(key, time);
    }

    @GetMapping("/test3")
    public void ThreadPoolTest() throws InterruptedException {
        redisTestService.ThreadPoolTest();
    }
}
