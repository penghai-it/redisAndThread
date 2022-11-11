package it.ph.com.redistest.controller;

import it.ph.com.redistest.model.SysUser;
import it.ph.com.redistest.service.AssertTestServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author PH
 * @时间： 2022/11/11
 * @描述：断言测试Controller
 */
@RestController
@RequestMapping("assert")
public class AssertTestController {
    @Autowired
    AssertTestServicer assertTestServicer;

    @GetMapping("/test")
    public Object test() {
        return assertTestServicer.assertTest();
    }

    @GetMapping("/test1")
    public Object test1(int number) {
        return assertTestServicer.assertTest1(number);
    }

    @PostMapping("/test2")
    public Object test2(@RequestBody SysUser sysUser) {
        return assertTestServicer.test2(null);
    }
}
