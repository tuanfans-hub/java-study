package thread_study.thread_lock.SynchronizedLockTelecom;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description
 */
public class CustomerThread implements Runnable{
    private volatile Product product;

    public CustomerThread(){}

    public CustomerThread(Product product){
        this.product = product;
    }
    @Override
    public void run() {
        for (int i = 0; ; i++) {
            product.getProduct();
        }
    }
}
