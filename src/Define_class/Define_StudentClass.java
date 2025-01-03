package Define_class;
//  学生类
//  成员变量：特征信息
//  成员方法：行为功能

public class Define_StudentClass {
        //成员变量：学生的特征信息：姓名、年龄、性别
        String name;
        int age;
        String sex;

        //成员方法：学生的行为：自我介绍
        public void read(){
            System.out.println("姓名："+name+"，年龄："+age+"，性别："+sex);
            System.out.println("未见全貌，不做置评。");
        }
    }