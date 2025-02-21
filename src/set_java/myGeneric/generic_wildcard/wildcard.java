package set_java.myGeneric.generic_wildcard;

import java.util.ArrayList;

/**
 * 泛型的通配符：
 * ?表示不确定的类型
 * 可以进行类型的限定
 * ? extends E：表示可以传递E或者E所有的子类类型
 * ? super E：表示可以传递E或者E所有的父类类型
 * 应用场景：
 * 1.如果我们在定义类、方法、接口的时候，如果类型不确定，就可以定义泛型类、泛型方法、泛型接口。
 * 2.如果类型不确定，但是能知道以后只能传递某个继承体系中的，就可以泛型的通配符
 * 泛型的通配符：
 * 关键点->可以限定类型的范围。
 * */
public class wildcard {
    public static void main(String[] args){
        ArrayList<ye>  yeList = new ArrayList<>();
        ArrayList<fu>  fuList = new ArrayList<>();
        ArrayList<zi> ziList = new ArrayList<>();
        ArrayList<yeBro> yeBroList = new ArrayList<>();
        ye_print(yeList);
        //ye_print(fuList);错误：只能传ArrayList<ye>类型作为参数
        System.out.println("--------------------------------");
        //ye_down_print(yeList);错误：只能传ArrayList<fu>及其子类对象作为参数
        fu_down_print(fuList);
        fu_down_print(ziList);
        System.out.println("--------------------------------");
        fu_super_print(yeList);
        fu_super_print(fuList);
        //fu_super_print(ziList);错误：只能传ArrayList<fu>及其父类对象作为参数
        System.out.println("--------------------------------");
        print(yeList);
        print(fuList);
        print(ziList);
        print(yeBroList);

    }

    // ye_print方法中的给定的参数是ArrayList<ye>类型的，
    // 所以只能传入ArrayList<ye>类型的参数，不能传入其他类型的参数
    public static void ye_print(ArrayList<ye> yeList){
        System.out.println("此处只打印\"ye\"类的对象...");
    }

    //fu_down_print方法中给定的参数是ArrayList<? extends fu>类型的，
    // 所以只能传入ArrayList<fu>及其子类对象作为参数，不能传入其他类型的参数
    public static void fu_down_print(ArrayList<? extends fu> fu_down){
        System.out.println("此处只打印\"fu\"类及其子类的对象...");
    }
    //fu_super_print方法中给定的参数是ArrayList<? super fu>类型的，
    // 所以只能传入ArrayList<fu>及其父类对象作为参数，不能传入其他类型的参数
    public static void fu_super_print(ArrayList<? super fu> fu_super){
        System.out.println("此处只打印\"fu\"类及其父类的对象...");
    }

    public static <E> void print(ArrayList<E> list){
        System.out.println("此处能打印任意类的对象...");
    }

}

abstract class ye {
    public abstract void print();
}
class fu extends ye{

    @Override
    public void print() {

    }
}
class zi extends fu{

}
abstract class yeBro{
    public abstract void print();
}