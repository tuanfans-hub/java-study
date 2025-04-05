package com.TuanFans.Dao.Impl;

import com.TuanFans.Dao.DeptDao;
import com.TuanFans.MySQL_File;
import com.TuanFans.pojo.Dept;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description DeptDao接口的实现类
 */
public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> findAll() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        List<Dept> depts = null;
        try{
            Class.forName(MySQL_File.getDriver());
            conn = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
            String SQL = "select * from mytest.dept";
            preparedStatement = conn.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            depts = new ArrayList<>();
            while(resultSet.next()){
                int deptno = resultSet.getInt("deptno");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                Dept dept = new Dept(deptno,dname,loc);
                depts.add(dept);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySQL_File.close(conn,preparedStatement);
        }
        return depts;
    }
}
