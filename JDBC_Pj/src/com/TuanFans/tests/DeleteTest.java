package com.TuanFans.tests;

import com.TuanFans.Dao.EmpDao;
import com.TuanFans.Dao.Impl.EmpDaoImpl;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description 删除数据测试类
 */
public class DeleteTest {
    public static void main(String[] args){
        EmpDao empDao= new EmpDaoImpl();
        int rows = empDao.deleteEmp(9999);
        System.out.println(rows>0?"删除成功":"删除失败");
    }
}
