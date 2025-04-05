package JDBC;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/3
 * &#064description
 */
public class Select_JDBC {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static final String USER = "TuanFans";
    private static final String PASSWORD = "217134";

    public static void main(String[] args){
        List<t_student2> student2s  = selectStudent2();
        if (student2s != null) {
            student2s.forEach(stu->System.out.println(stu));
        }

    }

    private static List<t_student2> selectStudent2() {
        List<t_student2> student2s = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            String SQL = "select * from t_student2;";
            resultSet = statement.executeQuery(SQL);
            student2s  = new ArrayList<>();
            while(resultSet.next()){
                int sno = resultSet.getInt("sno");
                String sname = resultSet.getString("sname");
                String gander = resultSet.getString("gander");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");
                String cname = resultSet.getString("cname");
                String email = resultSet.getString("email");
                // 封装到一个实体类对象
                t_student2 stu = new t_student2(sno, sname, gander, age, birthday, email);
                student2s.add(stu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(resultSet!=null){
                try {
                    resultSet.close();// 结果集不手动关闭也可以：在关闭statement对象时，会自动关闭结果集
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return student2s;
    }
}
