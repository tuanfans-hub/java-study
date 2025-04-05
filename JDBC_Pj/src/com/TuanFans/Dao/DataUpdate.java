package com.TuanFans.Dao;

import com.TuanFans.MySQL_File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description 数据更新：删除、添加、更新数据通用
 */
public class DataUpdate {
    public int dataUpdate(String sql, Object... values) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try{
            conn = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
            preparedStatement = conn.prepareStatement(sql);
            for(int i = 0; i < values.length; i++){
                preparedStatement.setObject(i+1,values[i]);
            }
            rows = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySQL_File.close(conn,preparedStatement);
        }
        return rows;
    }
}
