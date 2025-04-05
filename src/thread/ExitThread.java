package thread;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description 线程退出
 */
// 线程终止：
// 1.当线程完成任务后，会自动退出。
// 2.还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式
public class ExitThread {
    public static void main(String[] args) throws InterruptedException {
        OutThread ot = new OutThread();
        Thread t = new Thread(ot);
        t.start();

        // 在主线程中，通过改变ot.out的值控制线程t的退出
        Thread.sleep(10000); // 主线程休眠10秒
        ot.setOut(false);
        System.out.println("线程t退出！");
        System.out.println("主线程退出！");
    }
}

class OutThread implements Runnable{
    private int count;
    // 设置一个控制变量--实现对线程退出的控制
    private boolean out = true;

    public void setOut(boolean out){
        this.out = out;
    }
    @Override
    public void run() {

        while(out){
            System.out.println((++count)+",OutThread正在运行.....");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
