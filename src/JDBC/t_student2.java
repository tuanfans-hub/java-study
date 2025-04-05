package JDBC;

import java.io.Serializable;
import java.util.Date;

/**
 * @author TuanFans
 * &#064;date 2025/4/3
 * &#064description 封装结果集
 * entity实体类：和数据库表格名称和字段是一一对应的类
 * 该类的对象主要用处是存储从数据库中查询出来的数据
 * (1)类名与表名保持一致
 * (2)属性名与表中字段名保持一致
 * (3)属性类型与表中字段类型保持一致
 * (4)属性个数与表中字段个数保持一致
 * (5)属性私有化
 * (6)实体类推荐使用包装类
 * (7)提供对应的getter和setter方法
 * (8)必须具备空参构造方法
 * (9)实体类应当实现序列化接口(Serializable)
 */
public class t_student2 implements Serializable {
    private Integer sno;
    private String sname;
    private String gander;
    private Integer age;
    private Date birthday;
    private String email;

    public t_student2() {
    }

    public t_student2(Integer sno, String sname, String gander, Integer age, Date birthday, String email) {
        this.sno = sno;
        this.sname = sname;
        this.gander = gander;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return sno+" "+sname+" "+gander+" "+age+" "+birthday+" "+email;
    }
}
