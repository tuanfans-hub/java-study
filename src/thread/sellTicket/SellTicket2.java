package thread.sellTicket;

import java.util.Random;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description 线程通信案例：多线程卖票
 */
// 实现Runnable接口
public class SellTicket2 implements Runnable {
    private int ticket = 100;

    private final String name;

    public SellTicket2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random ran = new Random();
        int soldTickets;
        while (ticket > 0) {
            soldTickets = ran.nextInt(10) + 10;
            if(soldTickets>ticket){
                soldTickets = ticket;
            }
            ticket -= soldTickets;
            System.out.println(name + "售票窗口这次售出" + soldTickets + "张票" + "剩余" + ticket + "张票！");
            if(ticket==0){
                System.out.println(name+"售票窗口的票已经售完！");
            }
            System.out.println("---------------------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
