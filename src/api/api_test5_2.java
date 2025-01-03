package api;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

//判断一个年份是闰年还是平年
//修改版
public class api_test5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("jdk7");
        System.out.print("输入年份：");
        jdk7_isRun(sc.nextInt());
        System.out.println("----------------------");
        System.out.println("jdk8");
        System.out.print("输入年份：");
        jdk8_isRun(sc.nextInt());
        System.out.println("----------------------");
        System.out.println("jdk8自带判断方法");
        System.out.print("输入年份：");
        jdk8_isRun2(sc.nextInt());
    }

    //jdk7
    public static void jdk7_isRun(int year){
        Calendar c = Calendar.getInstance();
        c.set(year, Calendar.MARCH,1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        int day = c.get(Calendar.DAY_OF_MONTH);
        if(day == 28){
            System.out.println(year+"年是平年");
        }else{
            System.out.println(year+"年是闰年");
        }
    }

    //jdk8
    public static void jdk8_isRun(int year){
        LocalDate date = LocalDate.of(year,3,1);
        LocalDate date2 = date.minusDays(1);
        int day = date2.getDayOfMonth();
        if(day == 28){
            System.out.println(year+"年是平年");
        }else{
            System.out.println(year+"年是闰年");
        }
    }

    //jdk8自带判断方法
    public static void jdk8_isRun2(int year){
        LocalDate date = LocalDate.of(year,3,1);
        if(date.isLeapYear()){
            System.out.println(year+"年是闰年");
        }else{
            System.out.println(year+"年是平年");
        }
    }
}
