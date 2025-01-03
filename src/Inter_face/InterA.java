package Inter_face;
/*接口：接口使用interface关键字声明，语法格式：
* [public] interface 接口 [extends 接口1,接口2...]{
*       [public static final] 数据类型 常量名 = 常量;
*       [public abstract] 返回值的数据类型 方法名(参数列表);
*       [public] static 返回值的数据类型 方法名(参数列表){...}
*       [public] default 返回值的数据类型 方法名(参数列表){...}
* }
* [...]该部分可省略不写
* */
public interface InterA {
    //常量名
    public static final String name="路明泽";

    //抽象方法
    public abstract void Sex();

    //静态方法
    public static void age(){
        String age="年龄未知";
        System.out.println(age);
    }

    //默认方法
    public default void show(){
        System.out.println("我重临世界之日，诸逆臣皆当死去");
    }
}
