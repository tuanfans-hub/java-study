package wrapper_class;
//包装类：int(Integer)、char(Character)
public class wrapper_class {
    public static void main(String[] args){
        //1.通过构造方法创建包装类的对象
        //Integer I1 = new Integer(100);
        //Integer I2 = new Integer("100");
        //Integer(int)' 自版本 9 起已弃用并标记为移除

        //2.利用静态方法获取包装类对象
        Integer integer1 = Integer.valueOf(100);
        Integer integer2 = Integer.valueOf("100");
        Integer integer3 = Integer.valueOf("100",2);//指定进制，此处为二进制（100），即4
        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(integer3);
        System.out.println("---------------------------");
        //3.自动装箱：基本数据类型会自动变成其对应的包装类
        //自动拆箱：包装类会自动变成其对应的基本数据类型
        Integer i1 = 10;//自动装箱
        Integer i2 = Integer.valueOf("10");
        int i = i1 + i2;//自动拆箱
        System.out.println(i);
        System.out.println("---------------------------");
        //4.把十进制整数装成二进制数
        String number2 = Integer.toBinaryString(10);
        System.out.println(number2);//1010
        System.out.println("---------------------------");
        //5.把十进制整数装成八进制数
        String number8 = Integer.toOctalString(10);
        System.out.println(number8);//12
        System.out.println("---------------------------");
        //6.把十进制整数装成十六进制数
        String number16 = Integer.toHexString(10);
        System.out.println(number16);//a
        System.out.println("---------------------------");
        //7.把字符串类型的整数转成int类型的整数
        //除了Character没有对应的parseXxx方法外，其他包装类都有
        int number_string1 = Integer.parseInt("10",2);//把二进制的字符串“10”转成int类型的整数
        int number_string2 = Integer.parseInt("123456789");
        System.out.println(number_string1);//2
        System.out.println(number_string2);//123456789
        System.out.println("---------------------------");
    }
}
