package com.TuanFans.Dao;

import com.TuanFans.pojo.Dept;

import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description DeptDao接口
 */
public interface DeptDao {
    /**
     * 查询所有部门信息
     * @return Dept类型集合
     */
    List<Dept> findAll();
}
