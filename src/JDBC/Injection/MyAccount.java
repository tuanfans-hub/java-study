package JDBC.Injection;

import java.io.Serializable;

/**
 * @author TuanFans
 * &#064;date 2025/4/3
 * &#064description MyAccount实体类
 */
public class MyAccount implements Serializable {
    private Integer aid;
    private String username;
    private String password;
    private Integer money;

    public MyAccount() {
    }

    public MyAccount(Integer aid, String username, String password, Integer money) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return aid+" "+username+" "+password+" "+money;
    }
}
