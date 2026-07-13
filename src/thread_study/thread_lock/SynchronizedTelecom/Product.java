package thread_study.thread_lock.SynchronizedTelecom;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description 产品
 */
public class Product {
    private String name;

    private boolean isProduct = false;

    public Product() {}

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //生产
    public synchronized void setProduct(String name){
        if(isProduct){
            try {
                wait();//阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.isProduct = true;
        System.out.println("生产者生产了："+name);
        notify();//唤醒消费者
    }

    //消费
    public synchronized void getProduct(){
        if(!isProduct){
            try {
                wait();//阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者消费了："+name);
        this.isProduct = false;
        notify();//唤醒生产者
    }
}
