package com.TuanFans.tests;

import org.apache.log4j.Logger;

/**
 * @author TuanFans
 * &#064;date 2025/4/7
 * &#064description Log4j日志记录器
 */
public class Log4j {
    public static void main(String[] args){
        // 获取日志记录器；
        // 参数:
        // 1.一般为一个类的全路径名
        // 2.一个类的字节码
        Logger logger = Logger.getLogger("com.TuanFans.views.ManagerSystem");
        //    log4j日志的级别：
        //    FATAL：  指出现非常严重的错误事件，这些错误可能导致应用程序异常中止
        logger.fatal("fatal message!");
        //    ERROR： 指虽有错误，但仍允许应用程序继续运行
        logger.error("error message!");
        //    WARN：  指运行环境潜藏着危害
        logger.warn("warn message!");
        //    INFO：  指报告信息，这些信息在粗粒度级别上突出显示应用程序的进程
        logger.info("info message!");
        //    DEBUG： 指细粒度信息事件，对于应用程序的调试是最有用的
        logger.debug("debug message!");

        // 打印异常信息
        try {
            int i = 1/0;
        }catch (Exception e){
            logger.warn("异常信息：",e);
        }

    }
}
