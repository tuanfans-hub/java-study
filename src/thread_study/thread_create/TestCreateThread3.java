package thread_study.thread_create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author TuanFans
 * @date 2025/6/30
 * @description 创建线程方式3：实现Callable接口--重写call方法。始于JDK5.0；
 * 好处：可以定义返回值，可以抛出异常
 * 缺点：线程实现逻辑比较复杂
 */
public class TestCreateThread3 {
    public static void main(String[] args) {
        MyThread3 mt = new MyThread3();
        FutureTask<String> ft = new FutureTask<>(mt);
        Thread t = new Thread(ft, "窗口1");
        t.start();
        //获取返回值
        try {
            System.out.println(ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread3 implements Callable<String>{
    int count = 10;
    @Override
    public String call() throws Exception {
        while (count > 0){
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count--;
        }

        return Thread.currentThread().getName() + "表示票已售罄";
    }
}
