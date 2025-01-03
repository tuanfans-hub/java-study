package api;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar类：抽象类，代表了系统当前时间的日历对象，可以单独修改、获取时间的年、月、日
 * */
public class jdk7_api_Calendar {
    public static void main(String[] args){
        /*
         * 1.获取日历对象：Calender为抽象类，无法创建对象，只能通过方法获取其子类对象
         * 底层原理：
         * 会根据系统的的不同时区来获取不同的日历对象,默认为当前系统时间
         * 把时间的纪元、年、月、日、时、分、秒、星期等等时间信息放到一个数组中
         */
        System.out.println("------------------------------------------");
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        //java.util.GregorianCalendar[time=1731555662396,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=31,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=1,ERA=1,YEAR=2024,MONTH=10,WEEK_OF_YEAR=46,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=319,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=2,AM_PM=0,HOUR=11,HOUR_OF_DAY=11,MINUTE=41,SECOND=2,MILLISECOND=396,ZONE_OFFSET=28800000,DST_OFFSET=0]
        System.out.println("------------------------------------------");

        //2.修改日历时间
        Date date1 = new Date(0L);
        c.setTime(date1);
        System.out.println(c);
        //java.util.GregorianCalendar[time=0,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=31,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=1,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=1,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=8,HOUR_OF_DAY=8,MINUTE=0,SECOND=0,MILLISECOND=0,ZONE_OFFSET=28800000,DST_OFFSET=0]
        System.out.println("------------------------------------------");

        //3.获取日历时间的时间信息
        //获取的月份范围：0~11
        //获取的星期信息：周日为一个星期的第一天：1（周日）2（周一）...
        getDate(c);

        //4.修改日历字段
        c.set(Calendar.YEAR, 2024);//修改指定字段
        c.set(2024, Calendar.NOVEMBER,15);//修改年月日三个字段
        getDate(c);

        c.add(Calendar.YEAR,1);//在特定的字段增加指定的值
        getDate(c);
    }

    private static void getDate(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(year+"年"+month+"月"+day+"日 "+getWeek(week));
        System.out.println("------------------------------------------");
    }

    public static String getWeek(int week){
        String[] weeks={"","周日","周一","周二","周三","周四","周五","周六"};
        return weeks[week];
    }
}
