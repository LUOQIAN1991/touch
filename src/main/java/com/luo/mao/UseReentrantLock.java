package com.luo.mao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoq
 * @version 1.0
 * @date 2020/8/18 14:08
 */
public class UseReentrantLock {

    public static int a = 100;
    private static final Lock lock = new ReentrantLock(false);


    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(3);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        //模拟实际业务逻辑
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完后，释放
                        semp.release();
                    } catch (InterruptedException e) {
                    }
                }
            };
            exec.execute(run);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(semp.getQueueLength());
        // 退出线程池
        exec.shutdown();

    }



    public static  void test() {

        try {
            lock.tryLock(2, TimeUnit.SECONDS);
            Thread.sleep(1000L);
            a=a-1;
            System.out.println(Thread.currentThread().getName()+"还剩"+a);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }




    }
}

