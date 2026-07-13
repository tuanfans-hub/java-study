package thread_study.thread_lock.SynchronizedTelecom;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description
 */
public class TesTelecom {
    public static void main(String[] args) {
        Product p = new Product();
        // 创建生产者线程
        ProducerThread pt = new ProducerThread(p);
        Thread p_thread = new Thread(pt);
        // 创建消费者线程
        CustomerThread ct = new CustomerThread(p);
        Thread c_thread = new Thread(ct);
        p_thread.start();
        c_thread.start();
    }
}
