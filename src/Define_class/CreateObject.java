package Define_class;
/*
创建对象格式：
第一种
类名 对象名称 =null；
对象名称=new 类名();
第二种
类名 对象名称=new 类名();

使用对象：
使用成员变量：对象名.成员变量名
使用成员方法：对象名.成员方法名
        */
public class CreateObject {
    public static void main(String[] args){
        //创建学生对象
        Define_StudentClass stu = new Define_StudentClass();
        System.out.println(stu);//运行结果：Define_class.Define_StudentClass@1b6d3586（该对象的内存地址值）

        //使用对象
        stu.name = "蓝湛";
        stu.age = 20;
        stu.sex = "男";
        stu.read();
    }
}
