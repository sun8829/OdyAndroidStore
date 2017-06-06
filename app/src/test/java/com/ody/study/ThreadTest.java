package com.ody.study;

import org.junit.Test;

/**
 * Created by Samuel on 2017/6/6.
 */

public class ThreadTest {

    @Test
    public void joinTest() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        BThread bt = new BThread();
        AThread at = new AThread(bt);
        try {
            bt.start();
            Thread.sleep(2000);
            at.start();
            at.join();
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");

        sleep();
    }

    @Test
    public void waitTest() {
        new Thread(new waitRun1()).start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new waitRun2()).start();

        sleep();
    }

    @Test
    public void yieldTest() {
        new YieldThread1().start();
        new YieldThread2().start();

        sleep();
    }


    private void sleep() {
        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //join
    static class BThread extends Thread {
        public BThread() {
            super("[BThread] Thread");
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " start.");
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(threadName + " loop at " + i);
                    Thread.sleep(1000);
                }
                System.out.println(threadName + " end.");
            } catch (Exception e) {
                System.out.println("Exception from " + threadName + ".run");
            }
        }
    }

    static class AThread extends Thread {
        BThread bt;

        public AThread(BThread bt) {
            super("[AThread] Thread");
            this.bt = bt;
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " start.");
            try {
                bt.join();
                System.out.println(threadName + " end.");
            } catch (Exception e) {
                System.out.println("Exception from " + threadName + ".run");
            }
        }
    }

    //wait
    class waitRun1 implements Runnable {
        @Override
        public void run() {
            synchronized (ThreadTest.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    ThreadTest.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    class waitRun2 implements Runnable {
        @Override
        public void run() {
            synchronized (ThreadTest.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                ThreadTest.class.notify();
                //==================
                //区别
                //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }

    //Yield
    class YieldThread1 extends Thread {

        public YieldThread1() {
            super("thread1");
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {

                // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
//                yield();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("" + this.getName() + "-----" + i);
            }
        }
    }

    class YieldThread2 extends Thread {

        public YieldThread2() {
            super("thread2");
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("" + this.getName() + "-----" + i);
            }
        }
    }
}
