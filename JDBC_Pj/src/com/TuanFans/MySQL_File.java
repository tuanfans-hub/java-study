package com.TuanFans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/4
 * &#064description 封装MySQL数据库连接信息
 */
// allowPublicKeyRetrieval=true 允许通过公钥检索服务器的密钥
public class MySQL_File {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "TuanFans";
    private static final String PASSWORD = "217134";

    public static String getDriver() {
        return DRIVER;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    // 事务回滚
    public static void rollback(Connection conn){
        if(conn!=null){
            try{
                conn.rollback();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    // 回滚到最后保存点
    public static void rollback(Connection conn, List<Savepoint> savepoints ){
        if(conn!=null && !savepoints.isEmpty()){
            try{
                conn.rollback(savepoints.get(savepoints.size()-1));
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    // 回滚到指定保存点
    public static void rollback(Connection conn,List<Savepoint> savepoints,int index){
        if(conn!=null && !savepoints.isEmpty()){
            try{
                conn.rollback(savepoints.get(index));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    // 事务提交
    public static void commit(Connection conn){
        if(conn!=null){
            try{
                conn.commit();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    // 关闭资源
    public static void close(Connection conn, PreparedStatement prepStmt) {
        if (prepStmt != null) {
            try {
                prepStmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    // 关闭Connection连接
    public static void close(Connection conn){
        if(conn!=null){
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    // 关闭PreparedStatement
    public static void close(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

