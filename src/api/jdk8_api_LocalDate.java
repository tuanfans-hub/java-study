package api;

import java.sql.Time;
import java.time.*;

public class jdk8_api_LocalDate {
    public static void main(String[] args){
        /* LocalDate、LocalTime、LocalDateTime类
         * 1.LocalDateTime类型可通过toXxx()方法转换为LocalDate或LocalTime类型
         * 2.LocalDate类：年、月、日
         * 3.LocalTime类：时、分、秒
         * 4.LocalDateTime类：年、月、日、时、分、秒
         * 5.三个类具有相同名称的方法
         * */

        System.out.println("------------------------------");
        //1.获取当前时间
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDate nowDate = nowDateTime.toLocalDate();
        LocalTime nowTime = nowDateTime.toLocalTime();
        System.out.println(nowDateTime);
        System.out.println(nowDate);
        System.out.println(nowTime);
        System.out.println("------------------------------");
        //2.获取指定的时间
        LocalDateTime DateTime1 = LocalDateTime.of(2000,1,1,0,0,0);
        System.out.println(DateTime1);
        System.out.println("------------------------------");
        //3.getXxx()获取日历中的指定属性
        int year = nowDateTime.getYear();
        int month = nowDateTime.getMonthValue();
        int day = nowDateTime.getDayOfMonth();
        DayOfWeek dayofWeek = nowDateTime.getDayOfWeek();
        int hour = nowDateTime.getHour();
        int minute = nowDateTime.getMinute();
        int second  =nowDateTime.getSecond();
        System.out.println(dayofWeek);
        System.out.println(year+"年"+month+"月"+day+"日 "+dayofWeek+" "+hour+":"+minute+":"+second);
        System.out.println("------------------------------");
        //4.isXxx表示判断
        System.out.println(nowDateTime.isBefore(DateTime1));//false
        System.out.println(nowDateTime.isAfter(DateTime1));//true
        System.out.println("------------------------------");
        //5.withXxx表示修改
        LocalDateTime withDateTime = DateTime1.withYear(2024);
        System.out.println(withDateTime);
        System.out.println("------------------------------");
        //6.minusXxx表示减少
        LocalDateTime minusDateTime = DateTime1.minusMonths(1);
        System.out.println(minusDateTime);
        System.out.println("------------------------------");
        //7.plusXxx表示增加
        LocalDateTime plusDateTime = DateTime1.plusDays(1);
        System.out.println(plusDateTime);
        System.out.println("------------------------------");
        //8.判断今天是否是你的生日
        LocalDate birthDate = LocalDate.of(2003,1,1);
        LocalDate todayDate = LocalDate.now();

        MonthDay birthMonthDay = MonthDay.of(birthDate.getMonth(),birthDate.getDayOfMonth());
        MonthDay todayMonthDay = MonthDay.from(todayDate);
        System.out.println("今天是否是你的生日："+birthMonthDay.equals(todayMonthDay));
        System.out.println("------------------------------");
    }
}
