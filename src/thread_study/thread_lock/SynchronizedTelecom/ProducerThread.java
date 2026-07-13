package thread_study.thread_lock.SynchronizedTelecom;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description 生产者
 */
public class ProducerThread implements Runnable{
    private volatile Product product;// 共享变量

    public ProducerThread(){}

    public ProducerThread(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; ; i++) {
            if(i%2==0){
                product.setProduct("农夫山泉");
            }else{
                product.setProduct("营养快线");
            }
        }
    }
}
