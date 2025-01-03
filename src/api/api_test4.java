package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

//计算活了多少天
public class api_test4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //jdk7_getDays(sc);
        System.out.println("-------------------------------");
        try {
            jdk8_getDays(sc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //jdk7写法
    private static void jdk7_getDays(Scanner sc) {
        System.out.println("输入出生日期（yyyy年MM月dd日）：");
        String birthday = sc.nextLine();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd日");
        Date birthdayDate;
        try {
            birthdayDate = sdf.parse(birthday);
        } catch (ParseException e) {
            throw new RuntimeException("日期格式错误！");
        }
        long today = System.currentTimeMillis();
        long birthday_time = birthdayDate.getTime();
        System.out.println("你出生于"+birthday+"，\n至今为止，你已生活了"+ (today-birthday_time)/1000/60/60/24+"天。");
    }

    //jdk8写法
    private static void jdk8_getDays(Scanner sc) throws Exception {
        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println("依次输入出生年、月、日：");
        LocalDate birthday = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        if(birthday.isAfter(nowDate)){
            throw new Exception("出生日期错误！");
        }
        System.out.println("你出生于"+formatter.format(birthday)+"，\n至今为止，你已生活了"+ ChronoUnit.DAYS.between(birthday,nowDate)+"天。");
    }
}
