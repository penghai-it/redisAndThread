package it.ph.com.redistest.controller;

import it.ph.com.redistest.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author PH
 * @时间： 2022/9/27
 * @描述：
 */
@RestController
@RequestMapping("redis")
public class RedisTestController {
    private static final int BUFFER_SIZE = 2 * 1024;
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

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        for (int i : test) {
            if (i == 3) {
                continue;
            } else {
                System.out.println(i);
            }
        }
    }
}
