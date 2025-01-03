package Keyword_this;
/*this的主要作用：
    1.使用this关键字调用本类属性：当成员变量与局部变量重名时，this关键字用于区分调用成员变量。
    2.this关键字调用成员方法
    3.使用this关键字调用本类的构造方法
*/
public class MajorRole_this {
    private String name;
    private int age;

    public MajorRole_this(){
        System.out.println("请输入相关信息:");
    }
    public MajorRole_this(String name,int age){
        this.name=name;
        if(age>=0) {
            this.age = age;
        }else{
            System.out.println("年龄信息错误！");
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

    public void show(){
        System.out.println("姓名："+name+"，年龄："+age);
        System.out.println("输入信息成功！");
    }
}
