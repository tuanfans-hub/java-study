package com.TuanFans.pojo;

import java.io.Serializable;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description dept实体类
 */
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;

    public Dept(){

    }
    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return deptno+"\t"+dname+"\t"+loc;
    }
}
