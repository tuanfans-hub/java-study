package com.TuanFans.tests;

import com.TuanFans.Dao.DeptDao;
import com.TuanFans.Dao.Impl.DeptDaoImpl;
import com.TuanFans.pojo.Dept;

import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description Dept_FindAll测试类
 */
public class Dept_FindAllTest {
    public static void main(String[] args){
        DeptDao deptDao = new DeptDaoImpl();
        List<Dept> depts = deptDao.findAll();
        depts.forEach(System.out::println);
    }
}
