package thread.sellTicket;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description
 */
public class SellTicket3Test {
    public static void main(String[] args) {
        SellTicket3 st1 = new SellTicket3("t1");
        SellTicket3 st2 = new SellTicket3("t2");
        SellTicket3 st3 = new SellTicket3("t3");

        Thread t1 = new Thread(startIt(st1));
        Thread t2 = new Thread(startIt(st2));
        Thread t3 = new Thread(startIt(st3));
        t1.start();
        t2.start();
        t3.start();
    }

    public static Runnable startIt(SellTicket3 st){
        return () -> {
            while (st.getTicket() > 0) {
                st.sell();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

    }
}
