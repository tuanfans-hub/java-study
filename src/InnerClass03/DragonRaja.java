package InnerClass03;
/*使用static关键字修饰的成员内部类，只能访问外部类的静态成员。
* 通过外部类访问静态内部类成员时，可以跳过外部类直接访问静态内部类
*
* 创建静态内部类对象格式：
* 外部类名.静态内部类名 变量名=new 外部类名.静态内部类名();
* */
public class DragonRaja {
    static String name;
    String sex;//非外部静态成员，无法被静态内部类访问

    static class Student{
        int age;
        public void show(){
            System.out.println(name+","+age);
        }

        public static void show2(){
            System.out.println("SSS级静态方法档案被访问:\n诺诺，血统A级，毕业于卡塞尔学院！");
        }
    }
}
