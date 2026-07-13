package thread_study.thread_lock.SynchronizedLockTelecom;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description
 */
public class ProducerThread implements Runnable{
    private volatile Product product;

    public ProducerThread() {}

    public ProducerThread(Product product) {
        this.product = product;
    }
    @Override
    public void run() {
        for (int i = 0; ; i++) {
            if(i%2==0){
                product.setProduct("营养快线");
            }else{
                product.setProduct("农夫山泉");
            }
        }
    }
}
