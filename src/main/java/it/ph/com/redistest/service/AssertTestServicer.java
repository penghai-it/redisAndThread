package it.ph.com.redistest.service;

import it.ph.com.redistest.model.SysUser;

/**
 * @author PH
 * @时间： 2022/11/11
 * @描述：断言测试接口层
 */
public interface AssertTestServicer {

    Object assertTest();

    Object assertTest1(int number);


    Object test2(SysUser sysUser);
}
