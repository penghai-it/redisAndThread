package it.ph.com.redistest.service;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author PH
 * @时间： 2022/9/27
 * @描述：
 */
public interface RedisTestService {
    public boolean set(String key, Long value);

    public boolean hset(String key, String item, Long value);

    public boolean expire(String key, long time);

    //线程池测试
    public void ThreadPoolTest() throws InterruptedException;

    public void threadSout(String name, long time) throws InterruptedException;

    public void threadSout1(Lock lock, Condition condition) throws InterruptedException;
}
