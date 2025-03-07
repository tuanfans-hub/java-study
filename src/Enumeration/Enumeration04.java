package Enumeration;

/**
 * @author TuanFans
 * &#064;date 2025/3/7
 */
// 枚举类的常用方法
public class Enumeration04 {
    public static void main(String[] args) {
        // name() 方法，返回枚举常量的名称
        System.out.println(Season04.SPRING.name());// SPRING
        // ordinal()方法，返回枚举常量的索引（索引：枚举常量创建时顺序，从零开始）
        System.out.println(Season04.AUTUMN.ordinal());// 2
        // values() 方法：获取枚举类型的数组，元素为枚举类中定义的所有枚举对象
        Season04[] seasons = Season04.values();
        for(Season04 s : seasons){
            System.out.println(s);
        }
        // valueOf(String name)：返回枚举类中指定名称的枚举常量，参数必须是枚举类中定义的常量名
        Season04 season = Season04.valueOf("SUMMER");
        System.out.println(season);
        // compareTo(T o) : 比较两个枚举常量，比较的是编号，返回值是编号差值
        System.out.println(Season04.SPRING.compareTo(Season04.SUMMER));// -1
    }
}

enum Season04 {
    SPRING("春天","温暖"),
    SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),
    WINTER("冬天","寒冷");

    private final String name;
    private final String desc;

    Season04(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Season04{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
