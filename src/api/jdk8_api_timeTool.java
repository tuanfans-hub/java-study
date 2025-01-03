package api;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/*工具类：
* Duration类：时间间隔，侧重（秒，纳秒）
* Period类：时间间隔，侧重（年，月，日）
* ChronoUnit类：时间间隔（所有单位）
* */
public class jdk8_api_timeTool {
    public static void main(String[] args) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);
        LocalDateTime birthday = LocalDateTime.of(2003,2,2,0,0,0);
        System.out.println(birthday);

        System.out.println("-------------------------------");
        Duration duration = Duration.between(birthday,nowDateTime);
        System.out.println(duration);//PT191007H28M13.2234414S
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());

        System.out.println("-------------------------------");
        Period period = Period.between(birthday.toLocalDate(),nowDateTime.toLocalDate());
        System.out.println(period);//P21Y9M14D
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.toTotalMonths());

        System.out.println("-------------------------------");
        System.out.println("相差年数："+ChronoUnit.YEARS.between(birthday,nowDateTime)+"年");
    }
}
