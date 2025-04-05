package thread;

/**
 * @author TuanFans
 * &#064;date 2025/3/16
 * &#064;description  线程
 */
// 1.进程是指运行中的程序
// 2.进程是程序的一次执行过程，或是正在运行的一个程序。是动态过程：有它自身的产生、存在和消亡的过程
// 3.线程由进程创建的，是进程的一个实体;一个进程可以拥有多个线程
//     单线程：同一个时刻，只允许执行一个线程
//     多线程：同一个时刻，可以执行多个线程
// 4.并发：同一个时刻，多个任务交替执行，造成一种“貌似同时”的错觉，简单的说，单核cpu实现的多任务就是并发。
// 5.并行：同一个时刻，多个任务同时执行。多核cpu可以实现并行。
@SuppressWarnings("all")
public class Thread_ {
    public static void main(String[] args){
        // 查看电脑的核数
        Runtime runtime = Runtime.getRuntime();
        int cpus = runtime.availableProcessors();
        System.out.println("电脑的核数是："+cpus);
    }
}
