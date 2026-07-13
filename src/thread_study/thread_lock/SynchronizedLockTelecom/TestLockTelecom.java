package thread_study.thread_lock.SynchronizedLockTelecom;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description
 */
public class TestLockTelecom {
    public static void main(String[] args) {
        Product p = new Product();
        ProducerThread pt = new ProducerThread(p);
        CustomerThread ct = new CustomerThread(p);
        new Thread(pt).start();
        new Thread(ct).start();

    }
}
