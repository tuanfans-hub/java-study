package thread_study.thread_lock.SynchronizedTelecom;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description 消费者
 */
public class CustomerThread implements Runnable{
    private volatile Product product;// 共享变量

    public CustomerThread() {}

    public CustomerThread(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; ; i++) {
            product.getProduct();
        }
    }
}
