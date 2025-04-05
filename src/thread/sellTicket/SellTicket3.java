package thread.sellTicket;

import java.util.Random;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description
 */
public class SellTicket3 {
    private int ticket = 100;
    private final String name;

    public SellTicket3(String name) {
        this.name = name;
    }

    public int getTicket(){
        return ticket;
    }

    Random rand = new Random();
    private int soldTickets;

    public void sell() {
        soldTickets = rand.nextInt(10) + 10;
        if (soldTickets > ticket) {
            soldTickets = ticket;
        }
        ticket -= soldTickets;
        System.out.println(name + "售票窗口这次售出" + soldTickets + "张票" + "剩余" + ticket + "张票！");
        if (ticket == 0) {
            System.out.println(name + "售票窗口的票已经售完！");
        }
        System.out.println("---------------------------------");
    }
}
