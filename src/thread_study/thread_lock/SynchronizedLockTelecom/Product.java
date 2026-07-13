package thread_study.thread_lock.SynchronizedLockTelecom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author TuanFans
 * @date 2025/7/2
 * @description
 */
public class Product {
    private String name;

    private boolean hasProduct = false;
    //锁
    private final Lock lock = new ReentrantLock();
    //生产者等待队列
    private final Condition p_condition = lock.newCondition();
    //消费者等待队列
    private final Condition c_condition = lock.newCondition();

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
    public void setProduct(String name){
        lock.lock();//获取锁
        try{
            if(hasProduct){
                p_condition.await();//阻塞生产者进程，加入到等待队列中
            }
            Thread.sleep(1000);
            this.name = name;
            this.hasProduct = true;
            System.out.println("生产者生产了："+name);
            c_condition.signal();//从等待队列中唤醒消费者进程
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();//释放锁
        }
    }

    //消费
    public void getProduct(){
        lock.lock();
        try{
            if(!hasProduct){
                c_condition.await();
            }
            Thread.sleep(1000);
            System.out.println("消费者消费了："+name);
            this.hasProduct = false;
            p_condition.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
