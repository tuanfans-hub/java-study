package com.TuanFans.Dao;

import com.TuanFans.MySQL_File;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/6
 * &#064description 连接池
 */
public class MyConnectionPool {
    private static final int MAX_CONNECTION_COUNT = 10;
    private static final int INIT_CONNECTION_COUNT = 5;
    private static List<Connection> connections = null;

    // static块，在类加载时执行，只执行一次
    static{
        initConnectionPool();
    }

    private static void initConnectionPool() {
        connections = new LinkedList<>();
        try {
            for (int i = 0; i < INIT_CONNECTION_COUNT; i++) {
                Connection conn = createConnection();
                connections.addLast(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection createConnection(){
        try {
            Class.forName(MySQL_File.getDriver());
            return DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取Connection对象
    public static Connection getConnection() {
        Connection conn = null;
        if (!connections.isEmpty()) {
            conn = connections.removeFirst();
        } else {
            conn = createConnection();
        }
        return conn;
    }

    // 释放Connection对象或者返还Connection对象
    public static void returnConnection(Connection conn){
        if(conn!=null){
            try {
                if(conn.isClosed()){
                    if(connections.size()<MAX_CONNECTION_COUNT){
                        connections.addLast(conn);
                    }else{
                        MySQL_File.close(conn);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
