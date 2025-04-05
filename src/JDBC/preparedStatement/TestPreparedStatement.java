package JDBC.preparedStatement;

import JDBC.t_student2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/4
 * &#064description PreparedStatement的实现
 */
public class TestPreparedStatement {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true";
    private static final String USERNAME = "TuanFans";
    private static final String PASSWORD = "217134";
    // 更新数据库数据
    public static void updateToDB(String dataName,String data,Integer sno){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // 对待更新字段名做安全检测
        String[] dataNames = {"sno","sname","gander","age","birthday","cname","email"};
        boolean flag = false;
        for(String name:dataNames){
            if(name.equals(dataName)){
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("没有"+dataName+"字段");
        }
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String SQL = "update mytest.t_student2 set  "+dataName+" = ? where sno = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,data);
            preparedStatement.setInt(2,sno);
            int rows = preparedStatement.executeUpdate();// 返回值为收数据影响的行数
        }catch(Exception e){
            close(preparedStatement, connection);
        }
    }



    // 插入数据库数据
    public static void insertToDB(String sname,String gander,Integer age,Date birthday,String cname,String email){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String SQL = "insert into mytest.t_student2(sname,gander,age,birthday,cname,email) values(?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,sname);
            preparedStatement.setString(2,gander);
            preparedStatement.setInt(3,age);
            preparedStatement.setDate(4,birthday);
            preparedStatement.setString(5,cname);
            preparedStatement.setString(6,email);
            int rows = preparedStatement.executeUpdate();
        }catch(Exception e){
            close(preparedStatement,connection);
        }
    }

    // 删除数据库数据
    public static void deleteFromDB(Integer sno){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String SQL = "delete from mytest.t_student2 where sno = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,sno);
            int rows = preparedStatement.executeUpdate();
        }catch(Exception e){
            close(preparedStatement,connection);
        }
    }

    // 查询数据库数据
    public static t_student2 selectFromDb(Integer sno){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        t_student2 student = null;
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String SQL = "select * from mytest.t_student2 where sno = ?;";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,sno);
            ResultSet resultSet = preparedStatement.executeQuery();

            int sNo = resultSet.getInt("sno");
            String sName = resultSet.getString("sname");
            String gander = resultSet.getString("gander");
            int age = resultSet.getInt("age");
            Date birthday = resultSet.getDate("birthday");
            String cname = resultSet.getString("cname");
            String email = resultSet.getString("email");
            student = new t_student2(sNo, sName, gander, age, birthday, email);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        close(preparedStatement,connection);
        return student;
    }

    // 关闭资源
    public static void close(PreparedStatement preparedStatement, Connection connection) {
        if(preparedStatement !=null){
            try{
                preparedStatement.close();
            }catch(Exception e1){
                System.out.println(e1.getMessage());
                System.out.println("关闭资源失败");
            }
        }

        if(connection !=null){
            try{
                connection.close();
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println("关闭资源失败");
            }
        }
    }
}
