package com.TuanFans.views;

import com.TuanFans.Dao.DeptDao;
import com.TuanFans.Dao.EmpDao;
import com.TuanFans.Dao.Impl.DeptDaoImpl;
import com.TuanFans.Dao.Impl.EmpDaoImpl;
import com.TuanFans.pojo.Dept;
import com.TuanFans.pojo.Emp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * @author TuanFans
 * &#064;date 2025/4/5
 * &#064description
 */
public class ManagerSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final DeptDao deptDao = new DeptDaoImpl();
    private static final EmpDao empDao = new EmpDaoImpl();
    // 设置日期格式
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void main(String[] args) {
        while(true){
            showMenu();
            System.out.print("请输入服务序列：");
            int service = sc.nextInt();
            switch(service){
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
                case 3:
                    case3();
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    case5();
                    break;
                case 6:
                    case6();
                    break;
                case 0:
                    System.out.println("退出员工管理系统！");
                    System.exit(0);
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }

        }
    }

    private static void case6() {
        System.out.print("请输入工号：");
        int updateEmpno = sc.nextInt();
        System.out.print("请输入修改的字段名：");
        String keyName = sc.next();
        System.out.print("请输入修改的值：");
        Object value = sc.next();
        int row3 = empDao.updateEmp(updateEmpno, keyName, value);
        System.out.println(row3>0?"修改成功！":"修改失败！");
    }

    private static void case5() {
        System.out.print("请输入工号：");
        int rows2 = empDao.deleteEmp(sc.nextInt());
        System.out.println(rows2>0?"删除成功！":"删除失败！");
    }

    private static void case4() {
        System.out.println("添加员工信息中...");
        System.out.println("请输入员工信息!");
        System.out.print("请输入工号：");
        int empno = sc.nextInt();
        System.out.print("请输入姓名：");
        String ename = sc.next();
        System.out.print("请输入职位：");
        String job = sc.next();
        System.out.print("请输入上级工号：");
        int mgr = sc.nextInt();
        System.out.print("请输入入职日期：");
        LocalDate hiredate = LocalDate.parse(sc.next(),dtf);
        System.out.print("请输入工资：");
        Double sal = sc.nextDouble();
        System.out.print("请输入奖金：");
        Double comm = sc.nextDouble();
        System.out.print("请输入部门编号：");
        int deptno = sc.nextInt();
        Emp emp2 = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
        int rows1 = empDao.insertEmp(emp2);
        System.out.println(rows1>0?"添加成功！":"添加失败！");
    }

    private static void case3() {
        System.out.print("请输入工号：");
        Emp emp = empDao.selectEmp(sc.nextInt());
        System.out.println(emp);
    }

    private static void case2() {
        List<Dept> depts = deptDao.findAll();
        for(Dept dept : depts){
            System.out.println(dept);
        }
    }

    private static void case1() {
        List<Emp> emps = empDao.findAll();
        for(Emp emp : emps){
            System.out.println(emp);
        }
    }

    private static void showMenu() {
        System.out.println("***************************");
        System.out.println(" |   欢迎使用员工管理系统   |");
        System.out.println("***************************");
        System.out.println(" |   1.查询所有员工信息     |");
        System.out.println(" |   2.查询所有部门信息     |");
        System.out.println(" |   3.根据工号查询员工信息  |");
        System.out.println(" |   4.添加员工信息        |");
        System.out.println(" |   5.根据工号删除员工信息  |");
        System.out.println(" |   6.根据工号修改员工信息  |");
        System.out.println(" |   0.退出系统            |");
        System.out.println("***************************");
    }
}
