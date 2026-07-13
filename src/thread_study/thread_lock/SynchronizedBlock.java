package thread_study.thread_lock;

/**
 * @author TuanFans
 * @date 2025/6/30
 * @description 同步代码块
 */
public class SynchronizedBlock {
    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();
        Thread t1 = new Thread(ts, "窗口1");
        Thread t2 = new Thread(ts, "窗口2");
        Thread t3 = new Thread(ts, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketSystem implements Runnable{
    private static int ticket = 50;
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(ticket>0){
                synchronized(TicketSystem.class){
                    if(ticket>0){
                        System.out.println("我在"+Thread.currentThread().getName()+"抢到了第"+(ticket--)+"张票！");
                    }
                }
            }else{
                System.out.println(Thread.currentThread().getName()+"表示票已售完！");
                break;
            }

        }
    }
}