package thread;

/**
 * @author TuanFans
 * &#064;date 2025/3/16
 * &#064description 创建线程的方式
 */
//创建线程的两种方式
// 在java中线程使用有两种方法：
// 1.继承Thread类，重写run方法
// 2.实现Runnable接口，重写run方法
public class CreateTread {
    //线程应用案例1-继承Thread类
    //1）请编写程序，开启一个线程，该线程每隔1秒。在控制台输出“喵喵，我是小猫咪”
    //2）对上题改进：当输出80次喵喵，我是小猫咪，结束该线程
    //3）使用JConsole监控线程执行情况，并画出程序示意图！
    public static void main(String[] args){
        Cat cat = new Cat();
        cat.start();    // 启动线程
        // 当main线程启动子线程后，主线程不会阻塞，会继续执行下去
        for(int i = 0;i<10;i++){
            System.out.println("main线程执行中.......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("main线程名称："+Thread.currentThread().getName());
        System.out.println("main线程结束");
        /*
        * 主线程与子线程的关系：
        * 1.主线程结束，子线程继续执行：
        *   (1)如果主线程结束了，但子线程仍在运行，那么子线程会继续执行，直到它们完成自己的任务。
        *   (2)程序不会退出，直到所有非守护线程（包括子线程）都结束。
        * 2.守护线程：
        *   (1)如果子线程被设置为守护线程（通过setDaemon(true)），
        *   那么当主线程结束时，守护线程也会随之结束，即使它们还没有完成任务。
        * 3.显式终止子线程：
        *   (1)如果需要确保子线程在主线程结束时也结束，可以通过调用interrupt()方法来中断子线程，
        *   或者在子线程中设置一个标志位来控制其执行。
        * */
    }
}

class Cat extends Thread{
    @Override
    public void run(){
        // 线程每隔1秒。在控制台输出“喵喵，我是小猫咪”
        System.out.println("-------Cat线程开始-------");
        int i=0;
        while(i<20){
            System.out.println((i+1)+".\t喵喵，我是小猫咪");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
        System.out.println("Cat线程名称："+Thread.currentThread().getName());

    }
}