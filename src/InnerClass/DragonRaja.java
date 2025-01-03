package InnerClass;
/*类的5大成员：属性、方法、构造方法、代码块、内部类
* 成员内部类：在类内，方法外定义的类。
* 成员内部类可以访问外部类的所有成员
* 外部类要访问内部类的成员必须创建对象
* 格式：外部类.内部类名 对象名=new 外部类().new 内部类();
* */

public class DragonRaja {
    //外部类
    String name="诺诺";
    //String str1=str; 无法访问，需创建对象
    public DragonRaja() {
        System.out.println("卡塞尔学院");
    }

    //外部类方法
    public void printName(){
        System.out.println(name);
        System.out.println("----调用内部类方法测试----");
        DragonRaja.student student=new DragonRaja.student();
        student.show();
    }
    public void show2(){
        System.out.println(name+"，A级血统");
    }

    //当成员内部类对外不公开时，可以在外部类编写方法，对外提供内部类对象
    public yanLing getInstance(){
        return new yanLing();
    }

    //内部类
    class student{
        //成员内部类在JDK16之前不能定义静态变量，在JDK16之后可以定义定义静态变量
        String str = "我爱诺诺";
        DragonRaja dr = new DragonRaja();
        public void show(){
            dr.show2();
            System.out.println(str);
        }
    }

    private class yanLing{
        String yanLingName="言灵未知";
        public void show3(){
            System.out.println(yanLingName);
        }
    }
}
