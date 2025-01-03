package InnerClass02;
/*
* 局部内部类（方法内部类）：
* 有效范围只限于方法内部
* 局部内部类可以访问外部类的所有成员和方法
* 局部内部类中的变量和方法却只能在所属方法中访问
* */
public class DragonRaja {
    String name="诺诺";
    public void show(){
        int age=21;

        class add{
            public void ad(){
                System.out.println(name+","+age+"岁"+'\n'+"诺诺：其实每个人的人生都是一部公路片，别在乎跑去哪里，关键是一直在跑，反正最后的目的地一定是座墓碑。");
            }
        }
        add a=new add();//只能在所属方法内创建对象和调用方法
        a.ad();
    }
}
