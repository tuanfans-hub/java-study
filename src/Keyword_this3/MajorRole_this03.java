package Keyword_this3;
//使用this关键字调用无参构造方法

public class MajorRole_this03 {
    private String name;
    private int age;

    public MajorRole_this03(){
        System.out.println("输入相关信息：");
    }
    public MajorRole_this03(String name,int age){
        this();
        //使用this关键字调用无参构造方法，即MajorRole_this03();
        //使用this关键字调用构造方法，this();语句必须放在第一行有效代码上
        this.name=name;
        if(age>=0) {
            this.age = age;
        }else{
            System.out.println("年龄信息错误");
        }
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        if(age>=0){
            this.age=age;
        }else{
            System.out.println("年龄信息错误！");
        }
    }

    public void show02(){
        System.out.println("姓名："+name+",年龄："+age);
    }
}
