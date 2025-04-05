package com.TuanFans.tests;

import com.TuanFans.Dao.EmpDao;
import com.TuanFans.Dao.Impl.EmpDaoImpl;
import com.TuanFans.pojo.Emp;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description 查询数据测试类
 */
public class SelectTest {
    public static void main(String[] args){
        System.out.println("empno\tename\tjob\t\tmgr\t\thiredate\tsal\t\tcomm\tdeptno");
        EmpDao empDao = new EmpDaoImpl();
        Emp emp = empDao.selectEmp(7369);
        System.out.println(emp);
    }
}
