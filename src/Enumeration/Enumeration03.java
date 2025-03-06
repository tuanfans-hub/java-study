package Enumeration;

/**
 * @author TuanFans
 * &#064;date 2025/3/6
 */
//使用enum关键字定义枚举类
public class Enumeration03 {
    public static void main(String[] args){
        System.out.println(Season03.SPRING);
        System.out.println(Season03.SUMMER);
    }
}

// 关键字enum替代class
enum Season03{
    // 枚举类的对象常量属性的声明，每个对象属性之间用","隔开，末尾对象";"结束
    SPRING("春天","温暖"),
    SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),
    WINTER("冬天","寒冷");

    // 枚举类的属性放在常量对象之后
    private final String name;
    private final String desc;

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
