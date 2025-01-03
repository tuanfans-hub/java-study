package polymorphic;
/*多态：不同对象调用相同方法的不同行为
* 前提：1.必须有继承和实现方法
*      2.必须有方法重写
*      3.必须有父类引用指向子类对象
* 好处：提高方法的灵活性
* 弊端：无法使用子类对象特有的成员
* 如果想使用子类特有的成员，就需要向下转型：子类 对象名 = (子类)父类对象;
* */
public class KasselTest {
    public static void main(String[] args) {
        Kassel stu1=new Lu();
        stu1.Student();
        Kassel stu2=new Chu();
        stu2.Student();
        //父类引用指向子类对象

        System.out.println("------------------------------------");

        Lu stu3=new Lu();
        UseKassel(stu3);
        Chu stu4=new Chu();
        UseKassel(stu4);
        }
    public static void UseKassel(Kassel stu){
        stu.Student();
        if(stu instanceof Lu){
            Lu lu=(Lu)stu;
            lu.show();
        }
        //instanceof关键字：判断一个对象是否属于某个类（或接口）
        //如果是指定类的实例对象，则返回true，否则返回false
        //格式：对象 instanceof 类（或接口）
    }
    //方法必须写在类里面、方法外
    //如果一个方法中使用父类或父接口作为形式参数，将来调用该方法时，可以传递任意的子类对象
}
