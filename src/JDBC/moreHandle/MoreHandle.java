package JDBC.moreHandle;

import JDBC.MySQL_File;

import java.sql.*;
import java.util.LinkedList;

import static JDBC.preparedStatement.TestPreparedStatement.close;


/**
 * @author TuanFans
 * &#064;date 2025/4/4
 * &#064description 批处理、设置回滚点
 */
// 设置批处理开启&rewriteBatchedStatements=true，进行批处理是能提高性能
public class MoreHandle {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true";
    private static final String USERNAME = "TuanFans";
    private static final String PASSWORD = "217134";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        addMoreData();
    }

    // 批处理:向myaccount表中插入多条数据
    private static void addMoreData() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // 保存回滚点
        LinkedList<Savepoint> savepoints = new LinkedList<>();
        int rows = 0;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            connection.setAutoCommit(false);
            String SQL = "insert into mytest.myaccount (username,password,money) values (?,?,?)";
            // 批处理时，SQL语句后不要添加分号，会报错
            preparedStatement = connection.prepareStatement(SQL);
            // 设置参数
            int money = 1;
            for(int i = 1;i<=1000;i++){
                preparedStatement.setString(1,"username");
                preparedStatement.setString(2,"password");
                preparedStatement.setDouble(3,money++);
                //rows += preparedStatement.executeUpdate();
                preparedStatement.addBatch();// 将SQL语句加入一个批处理的批次中
                if(i%100==0){
                    int[] is = preparedStatement.executeBatch();
                    for(int t : is){
                        if(t==-2){
                            rows+=t;
                        }
                    }
                    preparedStatement.clearBatch();// 清空批处理中的数据
                    savepoints.addLast(connection.setSavepoint());// 设置回滚点
                }
                if(i==955){
                    //异常测试：测试事务回滚
                    int x = 1/0;
                }
            }
            int[] ints = preparedStatement.executeBatch();
            for(int j : ints){
                if(j==-2){
                    rows+=j;
                }
            }
            preparedStatement.clearBatch();
            /*
            * executeBatch()方法执行批处理，返回一个int数组，数组中存放的是：
            * 1.SUCCESS_NO_INFO：-2，表示成功插入数据
            * 2.EXECUTE_FAILED：-3，表示插入数据失败
            * */
        }catch(Exception e){
            MySQL_File.rollback(connection,savepoints);// 回滚事务
            e.printStackTrace();
        }finally{
            MySQL_File.commit(connection);// 提交事务
            close(preparedStatement,connection);
            rows = rows / -2;
            System.out.println("批处理共插入"+rows+"条数据!");
        }

    }
}
