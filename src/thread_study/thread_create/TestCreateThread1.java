package thread_study.thread_create;

/**
 * @author TuanFans
 * @date 2025/6/30
 * @description 创建线程方式1：继承Thread类--重写run方法；局限性：不能继承其他类；开发比较少使用
 */
public class TestCreateThread1 {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}

class MyThread extends Thread{
    private static int NUMBER = 10;
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(NUMBER>0){
                System.out.println("我在"+Thread.currentThread().getName()+"抢到了第"+(NUMBER--)+"张票！");
            }else{
                System.out.println(Thread.currentThread().getName()+"表示票已售完！");
                break;
            }

        }
    }

}