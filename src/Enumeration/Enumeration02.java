package Enumeration;

/**
 * @author TuanFans
 * &#064;date 2025/3/6
 */
//对Enumeration01的改进
@SuppressWarnings("all")
public class Enumeration02 {
    public static void main(String[] args){
        System.out.println(Season02.WINTER);
        System.out.println(Season02.SPRING);
    }
}

//实现自定义枚举类
class Season02{
    private final String name;
    private final String desc;

    public static final Season02 SPRING = new Season02("春天","温暖");
    public static final Season02 SUMMER = new Season02("秋天","凉爽");
    public static final Season02 AUTUMN = new Season02("夏天","炎热");
    public static final Season02 WINTER = new Season02("冬天","寒冷");
    //1.将构造器私有化，防止直接创建对象
    //2.去掉set方法，防止属性被修改
    //3.在Season内部，直接创建固定的对象
    //4.final修饰，保证不可变;final修饰的常量通常全部大写
    private Season02(String name,String desc){
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
        return "Season02{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}