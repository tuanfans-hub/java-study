package com.TuanFans.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author TuanFans
 * &#064;date 2025/4/7
 * &#064description 读取配置文件
 */
public class ReadProperties {
    public static void main(String[] args){
        Properties properties = new Properties();
        InputStream resourceAsStream = ReadProperties.class.getResourceAsStream("/jdbc.properties");
        // ReadProperties.class.getResourceAsStream：指向字节码根路径中的一个文件的IO流
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("MySQL_DRIVER："+properties.getProperty("MySQL_DRIVER"));
    }
}
