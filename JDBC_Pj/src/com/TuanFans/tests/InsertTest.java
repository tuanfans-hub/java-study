package com.TuanFans.tests;

import com.TuanFans.Dao.EmpDao;
import com.TuanFans.Dao.Impl.EmpDaoImpl;
import com.TuanFans.pojo.Emp;

import java.time.LocalDate;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description 添加数据测试类
 */
public class InsertTest {
    public static void main(String[] args) {
        // 在JDK8之后，LocalDate类替代了Date类
        // LocalDate.of(year,month,dayOfMonth):创建指定日期的LocalDate对象
        // Date.valueOf(LocalDate):将LocalDate对象转换为Date对象
        // toLocalDate():将Date对象转换为LocalDate对象
        Emp emp = new Emp(9999,"TuanFans","CLERK",7369,LocalDate.of(2003,2,2),10000.0,null,10);
        EmpDao empDao = new EmpDaoImpl();
        int rows = empDao.insertEmp(emp);
        System.out.println(rows>0?"添加成功!":"添加失败!");
    }
}
