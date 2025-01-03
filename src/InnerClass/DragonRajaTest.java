package InnerClass;


public class DragonRajaTest {
    public static void main(String[] args) {

        //创建外部类对象
        DragonRaja dra = new DragonRaja();
        dra.printName();
        //dra.show();无法访问

        System.out.println("----------------------");

        //创建内部类对象
        DragonRaja.student stu= new DragonRaja().new student();
        stu.show();
        //show();访问失败
        //stu.printName();无法访问

        System.out.println("----------------------");

        DragonRaja dra1 = new DragonRaja();
        dra1.show2();
        Object y=dra1.getInstance();
    }
}
