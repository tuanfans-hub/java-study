package api;
/*jdk8新增的事件对象都是不可变的。
* 如果修改、增加、减少了时间，调用者不会发生改变，而是产生一个新的时间对象
  */
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class jdk8_api_Date {
    public static void main(String[] args){
        System.out.println("-----------------------------------");
        //ZoneId类
        //1.获取所有时区名称
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);
        System.out.println(zoneIds.size());
        System.out.println("-----------------------------------");
        //2.获取当前系统的默认时区
        ZoneId systemZoneId = ZoneId.systemDefault();
        System.out.println(systemZoneId);//Asia/Shanghai
        System.out.println("-----------------------------------");
        //3.获取指定的时区
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId);
        System.out.println("-----------------------------------");

        //Instant类时间戳
        //1.获取当前时间的Instant对象(世界标准时间)
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println("-----------------------------------");
        //2.根据（秒/毫秒/纳秒）获取Instant对象
        Instant instantTime1 = Instant.ofEpochMilli(0L);//毫秒
        System.out.println(instantTime1);//1970-01-01T00:00:00Z
        Instant instantTime2 = Instant.ofEpochSecond(1L);//秒
        System.out.println(instantTime2);//1970-01-01T00:00:01Z
        Instant instantTime3 = Instant.ofEpochSecond(1L, 1000000000);//纳秒
        System.out.println(instantTime3);//1970-01-01T00:00:02Z
        System.out.println("-----------------------------------");
        //3.指定时区
        ZonedDateTime zonedDateTime1 = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1);
        System.out.println("-----------------------------------");
        //4.idXxx 判断
        //A.isBefore(Instant B)：A所表示时间是否在B所表示时间的前面
        System.out.println(instantTime1.isBefore(instantTime2));//true
        //A.isBefore(Instant B)：A所表示时间是否在B所表示时间的后面
        System.out.println(instantTime1.isAfter(instantTime2));//false
        System.out.println("-----------------------------------");
        //6.minusXxx(long millisTime)：减少指定时间
        Instant minusTime1 = instantTime1.minusMillis(1000L);
        System.out.println(minusTime1);//1969-12-31T23:59:59Z
        System.out.println("-----------------------------------");
        //7.plusXxx(long plusTime)：增加指定时间
        Instant plusTime1 = instantTime1.plusSeconds(10L);
        System.out.println(plusTime1);//1970-01-01T00:00:10Z
        System.out.println("-----------------------------------");

        //ZonedDateTime类，带时区的时间
        //1.获取当前时间对象（带时区）
        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        System.out.println(nowZonedDateTime);
        System.out.println("-----------------------------------");
        //2.获取指定时间对象（带时区）
        ZonedDateTime time1 = ZonedDateTime.of(2024,11,15,
                17,0,0,0,
                ZoneId.of("Asia/Shanghai"));
        System.out.println(time1);
        //通过Instant+时区的方式获取时间对象
        Instant instant1 = Instant.ofEpochSecond(0L);
        ZoneId zoneId1 = ZoneId.of("Asia/Shanghai");
        ZonedDateTime instantZone1 = ZonedDateTime.ofInstant(instant1, zoneId1);
        System.out.println(instantZone1);//1970-01-01T08:00+08:00[Asia/Shanghai]
        System.out.println("-----------------------------------");
        //3.withXxx(int time)：修改时间
        ZonedDateTime withTime1 = instantZone1.withYear(2000);
        System.out.println(withTime1);//2000-01-01T08:00+08:00[Asia/Shanghai]
        System.out.println("-----------------------------------");
    }
}
