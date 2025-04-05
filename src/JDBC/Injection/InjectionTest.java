package JDBC.Injection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author TuanFans
 * &#064;date 2025/4/3
 * &#064description 注入攻击测试类
 */
public class InjectionTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static final String USER = "TuanFans";
    private static final String PASSWORD = "217134";
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("-------------查询信息------------");
        System.out.print("username：");
        String user = sc.next();
        // 如果输入密码是输入一些SQL语句组合，可能发生SQL注入攻击；例如：d'or'1'='1等；
        // 这种特殊的输入会导致SQL语句的筛选条件恒为真，最后输出所有数据库数据。
        System.out.print("password：");
        String pwd = sc.next();
        System.out.println("-------------查询结果------------");
        MyAccount account = getMyAccount(user,pwd);
        System.out.println(account==null?"登入失败！":"登录成功！");

    }

    private static MyAccount getMyAccount(String user,String pwd){
        MyAccount account = null;
        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            statement = connection.createStatement();
            String SQL = "select * from myaccount where username = '" +user+ "' and password = '" +pwd+"';";
            // 由于这里SQL语句使用的是字符串拼接，所以存在SQL注入攻击的可能，所以需要使用PreparedStatement来防止SQL注入攻击
            // SQL注入攻击：通过构建特殊的输入作为参数传入Web应用程序，而这些输入大都是SQL语法里的一些组合，通过执行SQL语句，
            // 进而执行攻击者所要的操作，，其主要原因是程序没有细致地过滤用户输入的数据，致使非法数据侵入系统。
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()){
                int aid = resultSet.getInt("aid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int money = resultSet.getInt("money");
                account = new MyAccount(aid, username, password, money);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try{
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return account;
    }
}

