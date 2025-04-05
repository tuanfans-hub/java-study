package com.TuanFans.tests;

import com.TuanFans.Dao.EmpDao;
import com.TuanFans.Dao.Impl.EmpDaoImpl;
import com.TuanFans.pojo.Emp;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description 更新数据测试类
 */
public class UpdateTest {
    public static void main(String[] args){
        EmpDao empDao = new EmpDaoImpl();
        int rows = empDao.updateEmp(9999, "job", "KING");
        System.out.println(rows>0? "更新成功！":"更新失败！");
    }
}
