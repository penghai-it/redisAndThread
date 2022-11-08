package it.ph.com.redistest.controller;

import it.ph.com.redistest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PH
 * @时间： 2022/11/7
 * @描述：
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping("/test1")
    public void test1() {
        testService.groupingTest();
    }

    @RequestMapping("/test2")
    public Object test2() {
        return testService.getGroupingData();
    }

    @RequestMapping("/test3")
    public Object test3(String key) {
        return testService.deleteData(key);
    }
}
