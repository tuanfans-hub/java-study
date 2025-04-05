package thread.SellTicket2;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description
 */
public class SellTicks implements Runnable {
    private static int tickets = 50;    // 三个窗口共同卖50张票，所以票数设为静态变量实现数据共享
    private final String name;

    public SellTicks(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                System.out.println("票已售完！");
                break;
            }
            System.out.println(name+"售票窗口这次售出1张票,剩余" + (--tickets) + "张票！");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
