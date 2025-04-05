package com.TuanFans.tests;

import com.TuanFans.Dao.EmpDao;
import com.TuanFans.Dao.Impl.EmpDaoImpl;
import com.TuanFans.pojo.Emp;

import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description findAll测试类
 */
public class Emp_FindAllTest {
    public static void main(String[] args) {
        System.out.println("empno\tename\tjob\t\tmgr\t\thiredate\tsal\t\tcomm\tdeptno");
        EmpDao empDao = new EmpDaoImpl();
        List<Emp> emps = empDao.findAll();
        emps.forEach(System.out::println);
    }
}
