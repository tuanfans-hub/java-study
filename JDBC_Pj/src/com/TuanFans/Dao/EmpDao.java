package com.TuanFans.Dao;

import com.TuanFans.pojo.Emp;

import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description EmpDao接口
 */
public interface EmpDao {
    /**
     * 添加员工信息
     * @param emp Emp实例化对象
     * @return int 影响行数（生效行数）
     */
    int insertEmp(Emp emp);

    /**
     * 删除员工信息
     * @param empno 员工编号
     * @return int 影响行数（生效行数）
     */
    int deleteEmp(int empno);

    /**
     *
     * @param empno 员工编号
     * @param keyName 待修改的字段名
     * @param value 待修改的值
     * @return int 影响行数（生效行数）
     */
    int updateEmp(int empno,String keyName,Object value);

    /**
     * 通过员工编号查询员工信息
     * @param empno 员工编号
     * @return Emp类型的集合
     */
    Emp selectEmp(int empno);

    /**
     * 查询所有员工信息
     * @return Emp类型的集合
     */
    List<Emp> findAll();

    /**
     * 删除、修改、更新数据库数据通用
     * @param sql SQL语句
     * @param values 参数数组
     * @return int 影响行数（生效行数）
     */
    int dataUpdate(String sql,Object...values);
}
