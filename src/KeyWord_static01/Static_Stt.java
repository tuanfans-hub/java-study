package KeyWord_static01;
/*
* static关键字：如果在Java程序中使用static修饰属性，则该属性称为静态属性（也称全局属性）
* 静态属性可以使用类名直接访问，访问格式：类名.属性名
* 静态方法：在成员方法前加上static关键字，可以在不创建对象的情况下，通过类名直接调用该成员方法。静态方法访问格式1：类名.方法   或   实例对象名.方法
* */

public class Static_Stt {
    private String name;
    private int age;
    static String apartment;//静态属性

    static{
        System.out.println("《魔道祖师》");
    }//静态代码块，只执行一次

    {
        System.out.println("输入相关信息：");
    }//普通代码块，可执行多次

    public Static_Stt(){
    }
    public Static_Stt(String name, int age){
        this.name=name;
        if(age>=0){
            this.age=age;
        }else{
            System.out.println("年龄信息错误！");
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("年龄信息错误！");
        }
    }

    public void show(){
        System.out.println("姓名：" + name + "，年龄：" + age + "，门派：" + apartment);
    }
    public static void show02(){
        System.out.println("未见全貌，不做置评");
    }//静态方法：在静态方法中只能访问静态的成员
}
