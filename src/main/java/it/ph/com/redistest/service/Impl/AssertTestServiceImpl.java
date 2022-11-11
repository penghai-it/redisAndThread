package it.ph.com.redistest.service.Impl;

import it.ph.com.redistest.model.SysUser;
import it.ph.com.redistest.service.AssertTestServicer;
import org.springframework.stereotype.Service;

/**
 * @author PH
 * @时间： 2022/11/11
 * @描述：断言测试实现类
 */
@Service
public class AssertTestServiceImpl implements AssertTestServicer {
    @Override
    public Object assertTest() {

        return "调用成功";
    }

    /**
     * @param number 参数
     * @return: java.lang.Object
     * @创建者: PH
     * @时间: 2022/11/11
     * @描述:断言测试不过VM启动需要配置"-ea"参数不然无效（实际开发中不建议使用不属时不一定开启）
     **/

    @Override
    public Object assertTest1(int number) {
        assert (number > 10) : "参数值小于10,条件不满足,报异常了!";
        System.err.println("参数值大于10,满足条件了!");
        return new Exception().getMessage();
    }

    /**
     * @param sysUser 用户对象
     * @return: java.lang.Object
     * @创建者: PH
     * @时间: 2022/11/11
     * @描述:测试代码出现异常对异常进行捕获并且不返回代码继续往下执行不会结束
     **/

    @Override
    public Object test2(SysUser sysUser) {
        try {
            //Controller层传递的null,这里会报NullPointerException
            Integer userId = sysUser.getUserId();
            System.err.println(userId);
        } catch (Exception e) {
            System.out.println("出现异常了,打印异常信息：" + e.getMessage());
        }
        int a = 10;
        int b = 20;
        return a + b;
    }
}
