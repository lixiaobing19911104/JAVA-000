
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * <p>
 * 一个简单的代码参考：
 */
public class Homework03 {
    private static  int     result   = 0;
    volatile static boolean computed = false;

    public static void main(String[] args) {
        // test1 CountDownLatch
        // test2 ReentrantLock condition
        // test3 synchronized wait
        // test4 CyclicBarrier
        // test5 join
        // test6 Executor.submit
        // test7 future
    }

    @Test
    public void test1() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> method1(countDownLatch)).start();
        // 确保  拿到result 并输出
        countDownLatch.await();
        System.out.println("countdownLatch异步计算结果为：" + result);

        System.out.println("countdownLatch使用时间：" + (System.currentTimeMillis() - start) + " ms");

    }

    public static void method1(CountDownLatch countDownLatch) {
        try {
            result = sum();
        } finally {
            countDownLatch.countDown();
        }
    }

    @Test
    public void test2() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition     condition     = reentrantLock.newCondition();
        long          start         = System.currentTimeMillis();
        new Thread(() -> method2(reentrantLock, condition)).start();
        reentrantLock.lock();
        try {
            System.out.println("main抢到线程");
            if (!computed) {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        System.out.println("condition异步计算结果为：" + result);

        System.out.println("condition使用时间：" + (System.currentTimeMillis() - start) + " ms");


    }

    public static void method2(ReentrantLock reentrantLock, Condition condition) {
        reentrantLock.lock();
        try {
            System.out.println("method2抢到线程");
            result = sum();
        } finally {
            condition.signal();
            reentrantLock.unlock();
            computed = true;
        }
    }

    @Test
    public void test3() throws InterruptedException {
        synchronized (Homework03.class) {
            long start = System.currentTimeMillis();

            new Thread(() -> method3()).start();
            Homework03.class.wait();
            System.out.println("wait notify异步计算结果为：" + result);

            System.out.println("wait notify使用时间：" + (System.currentTimeMillis() - start) + " ms");

        }
    }

    public static void method3() {
        synchronized (Homework03.class) {
            result = sum();
            Homework03.class.notify();
        }
    }

    @Test
    public void test4() {
        long start = System.currentTimeMillis();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,
                () -> {
                    System.out.println("cyclicBarrier异步计算结果为：" + result);
                    System.out.println("cyclicBarrier使用时间：" + (System.currentTimeMillis() - start) + " ms");
                });
        new Thread(() -> method4(cyclicBarrier)).start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void method4(CyclicBarrier cyclicBarrier) {
        try {
            result = sum();
        } finally {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test5() {
        long   start  = System.currentTimeMillis();
        Thread thread = new Thread(() -> method5());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("join异步计算结果为：" + result);
        System.out.println("join使用时间：" + (System.currentTimeMillis() - start) + " ms");

    }

    public static void method5() {
        result = sum();
    }

    @Test
    public void test6() {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?>       future          = executorService.submit(() -> method6());
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程池future异步计算结果为：" + result);
        System.out.println("线程池future使用时间：" + (System.currentTimeMillis() - start) + " ms");

    }

    public static void method6() {
        result = sum();
    }

    @Test
    public void test7() throws InterruptedException, ExecutionException {
        long                start    = System.currentTimeMillis();
        Callable<Integer>   callable = () -> method7();
        FutureTask<Integer> future   = new FutureTask<>(callable);
        Thread              thread   = new Thread(future);
        thread.start();
        Integer result = future.get();
        System.out.println("future异步计算结果为：" + result);
        System.out.println("future使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    public static int method7() {
        return sum();
    }


    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
