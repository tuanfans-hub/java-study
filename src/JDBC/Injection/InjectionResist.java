package JDBC.Injection;

import java.sql.*;
import java.util.Scanner;

/**
 * @author TuanFans
 * &#064;date 2025/4/3
 * &#064description 防止SQL注入攻击
 */
// 值得注意的是，我们的Connector/J5.0.5及之后useServerPrepStmts默认false，就是默认没有开启预编译，之前默认为true，
// cachePrepStmts一直默认为false，需要我们手动设置才可以启用预编译，
// 在开启预编译的同时要同时开启预编译缓存才能带来些许的性能提升
// useServerPrepStmts=true&cachePrepStmts=true
public class InjectionResist {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true";
    private static final String USER = "TuanFans";
    private static final String PASSWORD = "217134";
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("-------------查询信息------------");
        System.out.print("username：");
        String user = sc.next();
        System.out.print("password：");
        String pwd = sc.next();
        System.out.println("-------------查询结果------------");
        MyAccount account = getMyAccount(user,pwd);
        System.out.println(account==null?"登入失败！":"登录成功！");

    }

    private static MyAccount getMyAccount(String user,String pwd){
        MyAccount account = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            //statement = connection.createStatement();
            //String SQL = "select * from myaccount where username = '" +user+ "' and password = '" +pwd+"';";
            /*
            * 使用PreparedStatement语句对象防止注入攻击
            * PreparedStatement可以使用 ? 作为参数占位符
            * connection.createStatement();获取普通Statement对象
            * connection.prepareStatement(SQL);继承了Statement对象,获取一个预编译语句对象
            * prepareStatement对象在setXXX方法上，会对单引号进行转译处理，也就是说:
            *   ?中的数据的单引号'会被转义成\'，这样单引号就不会破坏sql语句的结构，
            * */
            String SQL = "select * from myaccount where username = ? and password = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            // 设置参数：在获取预编译语句对象后，就可以使用setXXX方法设置参数
            preparedStatement.setString(1,user);// (占位符编号，替代占位符的数据)
            preparedStatement.setString(2,pwd);// 占位符编号是从1开始
            // 执行CURD，返回结果集
            ResultSet resultSet = preparedStatement.executeQuery();//不需要传入SQL语句
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
            if(preparedStatement!=null){
                try{
                    preparedStatement.close();
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

