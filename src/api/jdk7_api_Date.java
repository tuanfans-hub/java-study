package api;
import java.util.Date;
import java.util.Random;

public class jdk7_api_Date {
    /*Date时间类
    * jdk写好的一个JavaBean类，用于描述时间，精确到毫秒
    * 空参构造：默认为系统时间
    * 有参构造：表示指定时间
    * */

    public static void main(String[] args) {
        //创建对象表示时间
        Date date1 = new Date();
        System.out.println(date1);
        System.out.println("---------------------------");
        Date date2 = new Date(0L);//时间原点
        System.out.println(date2);
        System.out.println("---------------------------");

        //setTime方法修改时间
        date2.setTime(1000L);
        System.out.println(date2);
        System.out.println("---------------------------");

        //getTimme获取时间原点到该时间的毫秒值
        System.out.println(date1.getTime());
        System.out.println("---------------------------");

        //练习1；打印时间原点一年后的时间
        Date date3 = new Date(365*24*60*60*1000L);
        System.out.println(date3);
        System.out.println("---------------------------");

        //练习2：比较时间的前后关系
        Random random = new Random();
        Date date4 = new Date(Math.abs(random.nextInt()));
        Date date5 = new Date(Math.abs(random.nextInt()));

        if(date4.getTime()<date5.getTime()){
            System.out.println(date4+"在前\n"+date5+"在后");
        }else if(date4.getTime()==date5.getTime()){
            System.out.println("两时间均为"+date4+"，时间相等");
        }else{
            System.out.println(date5+"在前\n"+date4+"在后");
        }
    }
}
