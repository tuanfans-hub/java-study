package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类
 * 格式化：将时间进行格式化
 * 解析：将字符串表示的时间变成Date对象
 */
public class jdk7_api_SimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        //空参构造：默认格式
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date date1 = new Date();
        String time1 = sdf1.format(date1);
        System.out.println(time1);
        System.out.println("--------------------------");

        //有参构造：指定时间格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
        String time2 = sdf2.format(date1);
        System.out.println(time2);
        System.out.println("--------------------------");

        //解析
        String time3 = "2024年11月13日 00:00:00";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d = sdf3.parse(time3);
        System.out.println(d);
        System.out.println("--------------------------");

        //练习1：将2000-11-11转换为2000年11月11日
        String testTime = "2000-11-11";
        SimpleDateFormat testSdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat testSdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        Date testDate = testSdf1.parse(testTime);
        System.out.println(testSdf2.format(testDate));
        System.out.println("--------------------------");

        //练习2：秒杀活动
        //秒杀时间：2023年11月11日 00:00:00~2023年11月11日 00:10:00
        //小贾下单付款时间：2023年11月11日 00:01:00
        //小皮下单付款时间：2023年11月11日 00:11:00
        //判断两位同学是否参加秒杀活动
        String activityTime1 = "2023年11月11日 00:00:00";
        String activityTime2 = "2023年11月11日 00:10:00";
        String jia_pay_time = "2023年11月11日 00:01:00";
        String pi_pay_time = "2023年11月11日 00:11:00";
        SimpleDateFormat activitySdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date activityDate1 = activitySdf.parse(activityTime1);
        long startTime = activityDate1.getTime();
        Date activityDate2 = activitySdf.parse(activityTime2);
        long endTime = activityDate2.getTime();
        Date jia_pay_Date = activitySdf.parse(jia_pay_time);
        long jia_pay_Time = jia_pay_Date.getTime();
        Date pi_pay_Date = activitySdf.parse(pi_pay_time);
        long pi_pay_Time = pi_pay_Date.getTime();

        System.out.println("小贾是否成功参加秒杀活动："+activity(startTime,endTime,jia_pay_Time));
        System.out.println("小皮是否成功参加秒杀活动："+activity(startTime,endTime,pi_pay_Time));
    }

    public static boolean activity(long startTime,long endTime,long pay_time){
        return pay_time >= startTime && pay_time <= endTime;
    }
}
