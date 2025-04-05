package com.TuanFans.Dao.Impl;

import com.TuanFans.Dao.DataUpdate;
import com.TuanFans.Dao.EmpDao;
import com.TuanFans.pojo.Emp;
import com.TuanFans.MySQL_File;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description DeptDao接口的实现类
 */
public class EmpDaoImpl extends DataUpdate implements EmpDao {

    @Override
    public int insertEmp(Emp emp) {
//        Connection conn = null;
//        PreparedStatement preparedStatement = null;
//        int rows = 0;
//        try{
//            Class.forName(MySQL_File.getDriver());
//            conn = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
//            String SQL = "insert into mytest.emp values(?,?,?,?,?,?,?,?)";
//            preparedStatement = conn.prepareStatement(SQL);
//            preparedStatement.setInt(1,emp.getEmpno());
//            preparedStatement.setString(2,emp.getEname());
//            preparedStatement.setString(3,emp.getJob());
//            preparedStatement.setInt(4,emp.getMgr());
//            preparedStatement.setDate(5, Date.valueOf(emp.getHiredate()));
//            preparedStatement.setDouble(6,emp.getSal());
//            // comm字段为null时，使用setObject()方法
//            preparedStatement.setObject(7,emp.getComm());
//            preparedStatement.setInt(8,emp.getDeptno());
//            rows = preparedStatement.executeUpdate();
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            MySQL_File.close(conn,preparedStatement);
//        }
//        return rows;
        String sql = "insert into mytest.emp values(?,?,?,?,?,?,?,?)";
        return dataUpdate(sql,emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),Date.valueOf(emp.getHiredate()),emp.getSal(),emp.getComm(),emp.getDeptno());
    }

    @Override
    public int deleteEmp(int empno) {
//        Connection conn = null;
//        PreparedStatement preparedStatement = null;
//        int rows = 0;
//        try{
//            Class.forName(MySQL_File.getDriver());
//            conn = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
//            String SQL = "delete from mytest.emp where empno = ?";
//            preparedStatement = conn.prepareStatement(SQL);
//            preparedStatement.setInt(1,empno);
//            rows = preparedStatement.executeUpdate();
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            MySQL_File.close(conn,preparedStatement);
//        }
//        return rows;
        String sql = "delete from mytest.emp where empno = ?";
        return dataUpdate(sql,empno);
    }

    @Override
    public int updateEmp(int empno,String keyName,Object value) {
//        Connection conn = null;
//        PreparedStatement preparedStatement = null;
//        // 对待更新字段名做安全检测
//        String[] keyNames = {"ename","job","mgr","hiredate","sal","comm","deptno"};
//        boolean flag = false;
//        for(String name : keyNames){
//            if(name.equals(keyName)){
//                flag = true;
//                break;
//            }
//        }
//        if(!flag){
//            throw new RuntimeException("没有"+keyName+"字段");
//        }
//        int rows = 0;
//        try{
//            Class.forName(MySQL_File.getDriver());
//            conn = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
//            String SQL = "update mytest.emp set "+keyName +" = ? where empno = ?";
//            preparedStatement = conn.prepareStatement(SQL);
//            preparedStatement.setObject(1,value);
//            preparedStatement.setInt(2,empno);
//            rows = preparedStatement.executeUpdate();
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            MySQL_File.close(conn,preparedStatement);
//        }
//        return rows;
        // 对待更新字段名做安全检测
        String[] keyNames = {"ename","job","mgr","hiredate","sal","comm","deptno"};
        boolean flag = false;
        for(String name : keyNames){
            if(name.equals(keyName)){
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException("没有"+keyName+"字段");
        }
        String sql = "update mytest.emp set "+keyName +" = ? where empno = ?";
        return dataUpdate(sql,value,empno);
    }

    @Override
    public Emp selectEmp(int empno) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Emp emp = null;
        try{
            Class.forName(MySQL_File.getDriver());
            conn = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
            String SQL = "select * from mytest.emp where empno = ?";
            preparedStatement = conn.prepareStatement(SQL);
            preparedStatement.setInt(1,empno);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int empNo = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                LocalDate hiredate = resultSet.getDate("hiredate").toLocalDate();
                Double sal = resultSet.getDouble("sal");
                Double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                emp = new Emp(empNo,ename,job,mgr,hiredate,sal,comm,deptno);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySQL_File.close(conn,preparedStatement);
        }
        return emp;
    }

    @Override
    public List<Emp> findAll() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        List<Emp> emps = null;
        try{
            Class.forName(MySQL_File.getDriver());
            conn = DriverManager.getConnection(MySQL_File.getUrl(), MySQL_File.getUsername(), MySQL_File.getPassword());
            String SQL = "select * from mytest.emp";
            preparedStatement = conn.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            emps = new ArrayList<>();
            while(resultSet.next()){
                int empNo = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                LocalDate hiredate = resultSet.getDate("hiredate").toLocalDate();
                Double sal = resultSet.getDouble("sal");
                Double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                Emp emp = new Emp(empNo,ename,job,mgr,hiredate,sal,comm,deptno);
                emps.add(emp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            MySQL_File.close(conn,preparedStatement);
        }
        return emps;
    }

}
