package thread;

/**
 * @author TuanFans
 * &#064;date 2025/3/17
 * &#064description 创建线程方式二：实现Runnable接口
 */
public class CreateTread2 {
    public static void main(String[] args){
        // 直接创建一个线程
        Runnable r = ()->{
            int count = 0;
            while(count<10){
                System.out.println("线程1："+(++count));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t = new Thread(r);
        t.start();

        // 启动T1线程
        T1 r1 = new T1();
        Thread t1 = new Thread(r1);
        t1.start();
    }
}

class T1 implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while(count<10){
            System.out.println("线程T1："+(++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}