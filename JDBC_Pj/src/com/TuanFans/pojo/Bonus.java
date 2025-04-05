package com.TuanFans.pojo;

import java.io.Serializable;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description bonus实体类
 */
public class Bonus implements Serializable {
    private String ename;
    private String job;
    private double sal;
    private double comm;

    public Bonus(){

    }

    public Bonus(String ename, String job, double sal, double comm) {
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return ename+"\t"+job+"\t"+sal+"\t"+comm;
    }
}
