package thread;

/**
 * @author TuanFans
 * &#064;date 2025/3/19
 * &#064description 线程常用方法
 */
// 1.setName    设置线程名称，使之与参数name相同
// 2.getName    返回该线程的名称
// 3.start      使该线程开始执行；Java虚拟机底层调用该线程的start0方法
// 4.run       调用线程对象 run 方法;
// 5.setPriority更改线程的优先级
// 6.getPriority获取线程的优先级
// 7. sleep     在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）
// 8. interrupt 中断线程
// 9. isInterrupted 判断线程是否中断
public class MethodThread {
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(getRun());
        Thread t2 = new Thread(getRun());
        // 1.setName    设置线程名称，使之与参数name相同
        t1.setName("线程T1");
        t2.setName("线程T2");
        // 2.getName    返回该线程的名称
        System.out.println("T1:"+t1.getName());
        System.out.println("T2:"+t2.getName());
        // 5.setPriority更改线程的优先级，默认优先级为5
        t2.setPriority(Thread.MAX_PRIORITY);// t2优先级最高
        // 6.getPriority获取线程的优先级
        System.out.println("T1:"+t1.getPriority());
        System.out.println("T2:"+t2.getPriority());
        // 3.start      使该线程开始执行；Java虚拟机底层调用该线程的start0方法
        t1.start();
        t2.start();

        // 主线程休眠5s
        Thread.sleep(30000);
        // 8. interrupt 中断线程
        t1.interrupt(); // 让线程t1中断，但是线程t1的run方法中，InterruptedException被捕获并重新抛出，导致中断标志位被清除。
        // t1.interrupt()方法只是将线程的中断标志位置为true，并不会立即中断线程。线程是否中断取决于线程自身是否检查并处理了中断标志位。
        // 9. isInterrupted 判断线程是否中断
        System.out.println("t1是否中断："+t1.isInterrupted());
        // t1.isInterrupted()输出结果为false
        // 原因是：t1.isInterrupted()方法检查的是线程的中断标志位，而不是线程的实际中断状态。
        // 在调用t1.interrupt()后，线程的中断标志位被设置为true，但在t1线程的run方法中，
        // InterruptedException被捕获并重新抛出，导致中断标志位被清除。因此，t1.isInterrupted()返回false。
    }

    public static Runnable getRun(){
        return () -> {
            int count = 0;
            while(true){
                System.out.println(Thread.currentThread().getName()+":"+(++count));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+"被中断了");
                    throw new RuntimeException(e);
                }
                if(count==50){
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName()+"被中断了");
                        throw new RuntimeException(e);
                    }
                }
                if(count==100){
                    break;
                }
            }
        };
    }
}
