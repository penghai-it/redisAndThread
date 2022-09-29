package it.ph.com.redistest.service.Impl;

import it.ph.com.redistest.service.RedisTestService;
import it.ph.com.redistest.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author PH
 * @时间： 2022/9/27
 * @描述：
 */
@Service
public class RedisTestServiceImpl implements RedisTestService {
    @Autowired
    RedisTemplate redisTemplate;
    RedisUtil redisUtil = new RedisUtil();

    @Override
    public boolean set(String key, Long value) {
        return redisUtil.set(key, value, redisTemplate);
    }

    @Override
    public boolean hset(String key, String item, Long value) {
        return redisUtil.hsets(key, item, value, redisTemplate);
    }

    @Override
    public boolean expire(String key, long time) {
        return redisUtil.expire(key, time, redisTemplate);
    }

    @Override
    public void ThreadPoolTest() throws InterruptedException {
        // 创建锁
        final Lock lock = new ReentrantLock();
        // 创建 Condition
        final Condition condition = lock.newCondition();
        /*
         * 1.newCachedThreadPool
         * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                // 得到锁
                lock.lock();
                try {
                    // System.out.println("开始休眠线程");
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock(); // 释放锁
                System.out.println("线程休眠结束");
                long start = System.currentTimeMillis();
                try {
                    threadSout(Thread.currentThread().getName(), start);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
            threadSout1(lock, condition);
        }
    }

    @Override
    public void threadSout(String name, long time) throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(name + ",  ====>当前时间：" + format);
        // System.out.println(name + "消耗时间：" + String.format("Total Time：%d ms", System.currentTimeMillis() - time));

    }

    @Override
    public void threadSout1(Lock lock, Condition condition) throws InterruptedException {

        lock.lock(); // 得到锁
        for (int i = 0; i < 10; i++) {
            //Thread.sleep(100);
            if (i == 5) {
                System.out.println("开始唤醒线程");
                condition.signalAll();
                lock.unlock(); // 释放锁
            }
            //System.out.println(Thread.currentThread().getName() + "线程开始循环第：" + i + "次了");
        }
    }
}
