package thread;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description 线程插队
 */
/*
1.yield：线程的礼让。让出cpu，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
2.join：线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有的任务
    案例：创建一个子线程，每隔1s输出hello，输出20次，主线程每隔1秒，输出hi，输出20次.要求：两个线
程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续
* */
public class YieldThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(getRun("hello"));
        //Thread hi = new Thread(getRun("hi"));
        hello.setName("hello线程");
        //hi.setName("hi线程");
        hello.start();
        //hi.start();
        hello.setPriority(Thread.MIN_PRIORITY);
        System.out.println("hello线程优先级："+hello.getPriority());
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "：hi," + (i+1));
            if (i == 4) {
                hello.join();   // hello线程插队
                //Thread.yield();   // 是否礼让取决于CPU内存是否紧张
            }
            Thread.sleep(1000);

        }
    }

    public static Runnable getRun(String context) {
        return () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + context + "," + (i+1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "被中断了");
                    throw new RuntimeException(e);
                }
            }

        };
    }
}
