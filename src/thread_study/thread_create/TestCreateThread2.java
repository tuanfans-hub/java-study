package thread_study.thread_create;

/**
 * @author TuanFans
 * @date 2025/6/30
 * @description 创建线程方式二：实现Runnable接口--重写run方法；局限性：没有返回值；不能抛出异常
 */
public class TestCreateThread2 {
    public static void main(String[] args) {
        MyThread2 mt1 = new MyThread2();
        Thread t1 = new Thread(mt1,"窗口1");
        Thread t2 = new Thread(mt1,"窗口2");
        Thread t3 = new Thread(mt1,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread2 implements Runnable{
    private int count = 10;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(count>0){
                System.out.println("我在"+Thread.currentThread().getName()+"中，抢到了第"+(count--)+"张票！");
            }else{
                System.out.println(Thread.currentThread().getName()+"表示票已售完！");
                break;
            }
        }
    }
}
