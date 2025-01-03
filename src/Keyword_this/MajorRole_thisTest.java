package Keyword_this;

public class MajorRole_thisTest {
    public static void main(String[] args) {
        MajorRole_this stu=new MajorRole_this();

        MajorRole_this stu1=new MajorRole_this("魏无羡",20);
        stu1.show();

        System.out.println("");

        MajorRole_this stu2=new MajorRole_this();
        stu2.setName("蓝湛");
        stu2.setAge(20);
        stu2.show();
    }
}
