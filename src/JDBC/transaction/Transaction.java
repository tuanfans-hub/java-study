package JDBC.transaction;

import JDBC.MySQL_File;

import java.sql.*;
import java.util.Scanner;

/**
 * @author TuanFans
 * &#064;date 2025/4/4
 * &#064description 事务
 */

public class Transaction {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入转出账号：");
        int aid1 = sc.nextInt();
        System.out.print("请输入转入账号：");
        int aid2 = sc.nextInt();
        System.out.print("请输入转账金额：");
        double money = sc.nextDouble();
        boolean flag = transactionTest(aid1,aid2,money);
        System.out.println(flag ? "转账成功！" : "转账失败！");
    }

    private static boolean transactionTest(Integer aid1,Integer aid2,double money){
        boolean flag = false;// 标志位: 用于记录转账事务是否成功
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        /*
         * JDBC的事务是默认自动提交的，
         * 想手动控制事务，需要手动设置自动提交事务为false,即connection.setAutoCommit(false);
         * */
        try{
            Class.forName(MySQL_File.getDriver());
            connection  = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
            connection.setAutoCommit(false);
            String SQL = "update mytest.myaccount set money = money-? where aid = ?";
            preparedStatement = connection.prepareStatement(SQL);
            // 钱款转出
            preparedStatement.setDouble(1,money);
            preparedStatement.setInt(2,aid1);
            // 执行
            preparedStatement.executeUpdate();
            // 异常测试：如果没有回滚操作，检测异常后，程序跳过转入的操作，钱款转出后，未能转入目标账户，导致钱款金额不匹配
            int i = 1/0;
            // 钱款转入
            preparedStatement.setDouble(1,-money);
            preparedStatement.setInt(2,aid2);
            // 执行
            preparedStatement.executeUpdate();
            flag = true;
        }catch(Exception e){
            // 回滚事务
            MySQL_File.rollback(connection);
            e.printStackTrace();
        }finally{
            // 在finally语句块中提交事务
            MySQL_File.commit(connection);
            // 关闭资源
            MySQL_File.close(connection,preparedStatement);
        }
        return flag;
    }
}
