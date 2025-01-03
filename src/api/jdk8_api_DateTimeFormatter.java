package api;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//DateTimeFormatter类：用于时间的格式化和解析
public class jdk8_api_DateTimeFormatter {
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        ZonedDateTime nowTime= Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        //时间格式/解析器
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 EE a HH:mm:ss");
        System.out.println(dtf1.format(nowTime));
        System.out.println("------------------------------------");
    }
}
