package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

//判断一个年份是闰年还是平年
public class api_test5 {
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
    }

    //jdk7
    public static void jdk7_isRun(int year) {
        String year_str = year + "-3-1";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        Date date2;
        try {
            date = sdf.parse(year_str);
            date2 = sdf.parse(year +"-02-29");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long beforeDay = date.getTime()-24*60*60*1000;
        long date2_day = date2.getTime();
        if(beforeDay==date2_day) {
            System.out.println(year+"年是闰年");
        }else{
            System.out.println(year+"年是平年");
        }
        //Date beforeDate = new Date(beforeDay);
        //String beforeDate_str = sdf.format(beforeDate);
        //System.out.println(year_str+"的前一天是"+beforeDate_str);
        /*
        if(beforeDate_str.equals(year +"-02-29")) {
            System.out.println(year+"年是闰年");
        }else{
            System.out.println(year+"年是平年");
        }
         */
    }

    //jdk8
    public static void jdk8_isRun(int year){
        LocalDate dateTime = LocalDate.of(year,3,1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate beforeOfDate = dateTime.minusDays(1);
        String beforeOfDateStr = dtf.format(beforeOfDate);
        if(beforeOfDateStr.equals(year+"-02-29")){
            System.out.println(year+"年是闰年");
        }else{
            System.out.println(year+"年是平年");
        }
    }
}
