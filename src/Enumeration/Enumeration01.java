package Enumeration;

/**
 * @author TuanFans
 * &#064;date  2025/3/6
 */
//枚举：
//  1）枚举对应英文（enumeration，简写enum）
//  2）枚举是一组常量的集合。
//  3）可以这里理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象。
//枚举的二种实现方式：
//  1）自定义类实现枚举
//      1.不需要提供setXxx方法，因为枚举对象值通常为只读
//      2.对枚举对象/属性使用final+static共同修饰，实现底层优化.
//      3.枚举对象名通常使用全部大写，常量的命名规范。
//      4.枚举对象根据需要，也可以有多个属
//  2)使用enum关键字实现枚举
public class Enumeration01 {
    public static void main(String[] args){
        Season s1 = new Season("春天","温暖");
        Season s2 = new Season("夏天","炎热");
        Season s3 = new Season("秋天","凉爽");
        Season s4 = new Season("冬天","寒冷");
        //因为季节只有4个，不会更多
        // 这样设计不好==> 解决这个问题--枚举类
        Season s5 = new Season("白天","明亮");
    }
}

class Season{
    private String name;
    private String desc;
    public Season(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
