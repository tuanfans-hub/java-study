package thread_study.thread_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author TuanFans
 * @date 2025/6/30
 * @description 同步代码块
 */
public class SynchronizedLock {
    public static void main(String[] args) {
        TicketSystem3 ts = new TicketSystem3();
        Thread t1 = new Thread(ts, "窗口1");
        Thread t2 = new Thread(ts, "窗口2");
        Thread t3 = new Thread(ts, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketSystem3 implements Runnable{
    private static int ticket = 50;
    Lock lock = new ReentrantLock();// 创建锁对象;不要在方法或循环中创建锁对象，否则可能会不是同一把锁导致锁不住
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println("我在" + Thread.currentThread().getName() + "抢到了第" + ticket + "张票！");
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "表示票已售完！");
                    break;
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }

        }
    }
}