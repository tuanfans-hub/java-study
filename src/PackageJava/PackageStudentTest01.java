package PackageJava;

public class PackageStudentTest01 {
    public static void main(String[] args) {
        PackageStudent stu = new PackageStudent();//构造方法被自动调用
        stu.setName ("魏无羡");
        stu.setAge (20);
        stu.setSex ("男");
        stu.show();

        System.out.println("");
        PackageStudent stu1 = new PackageStudent("蓝湛",20,"男");
        stu1.show();
    }
}
