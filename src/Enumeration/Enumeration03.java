package Enumeration;

/**
 * @author TuanFans
 * &#064;date 2025/3/6
 */
//使用enum关键字定义枚举类
@SuppressWarnings("all")
public class Enumeration03 {
    public static void main(String[] args){
        // 如果不重写toString方法，将调用Season03这个类父类Enum的toString方法
        // Enum类重写了toString方法，返回的是枚举对象的名称
        System.out.println(Season03.SPRING);
        System.out.println(Season03.SUMMER);
        System.out.println(Season03.What);
    }
}

// 关键字enum替代class
// 使用关键字enum定义的枚举类，默认继承自java.lang.Enum类
// 在Java中，一个类只能继承一个父类，所以使用关键字enum定义的枚举类不可以再继承其他类，但可以实现接口
enum Season03{
    // 枚举类的对象常量属性的声明，每个对象属性之间用","隔开，末尾对象";"结束
    // 枚举类对象属于静态对象
    SPRING("春天","温暖"),
    SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),
    WINTER("冬天","寒冷"),
    What;

    // 枚举类的属性放在常量对象之后
    // 枚举类的属性如果使用final修饰，那么不能创建无参构造方法，否则需要在无参构造方法中赋值
    // 在对象常量属性的声明中，可声明What()作为常量，表示无参构造方法，小括号可省略
//    private final String name;
//    private final String desc;
    private String name;
    private String desc;

    Season03(){
        //未对name和desc赋值，所以调用该构造方法时各属性都为null
    }
    Season03(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season03{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
