package KeyWord_static01;

public class StaticSttTest {
    public static void main(String[] args) {

        Static_Stt.apartment="云深不知处";
        //静态属性访问格式：类名.属性名。静态属性赋值后，所在类的该属性都为相同值；

        Static_Stt man01=new Static_Stt();
        man01.setName("魏无羡");
        man01.setAge(20);
        man01.show();

        man01.show02();
        //静态方法访问格式1：实例对象名.方法

        System.out.println("-----------------------------------");

        Static_Stt man02=new Static_Stt("蓝湛",20);
        man02.show();

        Static_Stt.show02();
        //静态方法访问格式2：类名.方法
    }
}
