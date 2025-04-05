package thread.SellTicket2;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description
 */
public class Test {
    public static void main(String[] args){
        SellTicks s1 = new SellTicks("T1");
        SellTicks s2 = new SellTicks("T2");
        SellTicks s3 = new SellTicks("T3");

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);

        t1.start();
        t2.start();
        t3.start();
    }
}
