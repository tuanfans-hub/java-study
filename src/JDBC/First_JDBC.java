package JDBC;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author TuanFans
 * &#064;date 2025/3/30
 * &#064description 数据库连接技术jDBC
 */
/*
* 数据库连接技术JDBC：用于执行SQL语句的Java API，为多种关系型数据库提供统一访问
* 使用JDBC步骤：
* 1.导入数据库驱动jar包（添加依赖）
* */
public class First_JDBC {
    // 1.定义数据库连接信息：将数据库连接信息定义为成员变量，便于引用，同时简洁代码
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static final String USER = "TuanFans";
    private static final String PASSWORD = "217134";
    public static void main(String[] args){
        //2.加载、注册驱动Driver
        // 方式一：使用Driver实例，Driver实例化之后还需要手动注册驱动
        //Driver driver = new com.mysql.cj.jdbc.Driver();
        //注册驱动DriverManager
        //DriverManager.registerDriver(driver);

        // 方式二：通过反射加载、注册Driver驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        // 即使不手动加载驱动，JDBC会自动加载驱动，所以可以省略；但是并不是所有版本都会自动加载驱动，所以还是建议手动加载、注册驱动

        //3.获得数据库连接Connection
        //参数1：数据库连接的url
            /*1.协议：jdbc:mysql:
              2.IP：127.0.0.1或者localhost
              3.端口号：3306
              4.数据库名称：mytest
              5.参数：
            * */
        //参数2：用户名
        //参数3：密码
        //String url = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        //String user = "TuanFans";
        //String password = "217134";
        //Connection conn = DriverManager.getConnection(url,user,password);

        //4.获得语句对象Statement
        //Statement statement = conn.createStatement();

        //5.执行SQL语句
        //String sql =
        //        "insert into t_student2 (sname,age,birthday,email) values ('田七',20,'2000-11-16','tianqi@tq.com');";
        //int rows = statement.executeUpdate(sql);// 返回一个int值，表示受影响的行数
        // insert、delete、update操作都是调用statement.executeUpdate()方法
        //System.out.println("影响的行数："+rows);

        //6.释放资源
        // 释放顺序：先创建的后释放
        //statement.close();
        //conn.close();


        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            statement = conn.createStatement();
            String sql =
                    "insert into t_student2 (sname,age,birthday,email) values ('田七',20,'2000-11-16','tianqi@tq.com');";
            int rows = statement.executeUpdate(sql);
            System.out.println("影响的行数："+rows);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(statement!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
