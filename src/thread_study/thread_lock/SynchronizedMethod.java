package thread_study.thread_lock;

/**
 * @author TuanFans
 * @date 2025/6/30
 * @description
 */
public class SynchronizedMethod {
    public static void main(String[] args) {
        TicketSystem2 ts2 = new TicketSystem2();
        Thread t1 = new Thread(ts2, "窗口1");
        Thread t2 = new Thread(ts2, "窗口2");
        Thread t3 = new Thread(ts2, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketSystem2 implements Runnable{
    private int count = 50;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(count>0){
                saleTicket();
            }else{
                System.out.println(Thread.currentThread().getName()+"表示票已售罄！");
                break;
            }
        }
    }

    public synchronized void saleTicket(){
        if(count>0){
            System.out.println(Thread.currentThread().getName()+"正在出售第"+count+"张票");
            count--;
        }
    }
}
