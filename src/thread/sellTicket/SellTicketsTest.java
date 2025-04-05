package thread.sellTicket;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description
 */
public class SellTicketsTest {
    public static void main(String[] args) {
        SellTicket st1 = new SellTicket("t1");
        st1.start();

        SellTicket st2 = new SellTicket("t2");
        st2.start();

        SellTicket st3 = new SellTicket("t3");
        st3.start();
    }

}
