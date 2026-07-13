package thread_study.thread_create;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author TuanFans
 * @date 2025/6/30
 * @description 创建一个时钟
 */
public class TestClock {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        new Thread(()->{
            try {
                while (true) {
                    System.out.println(showTime());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static String showTime(){
        LocalDateTime now = LocalDateTime.now();
        return DTF.format(now);
    }
}


