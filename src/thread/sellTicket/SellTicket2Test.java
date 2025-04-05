package thread.sellTicket;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description
 */
public class SellTicket2Test {
    public static void main(String[] args){
        SellTicket2 st1 = new SellTicket2("t1");
        SellTicket2 st2 = new SellTicket2("t2");
        SellTicket2 st3 = new SellTicket2("t3");
        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st2);
        Thread t3 = new Thread(st3);
        t1.start();
        t2.start();
        t3.start();
    }
}
