package Inherit;

public class DragonRajaTest {
    public static void main(String[] args) {
        System.out.println("Dragon Raja");
        System.out.println("《龙族》");

        System.out.println("-----------------------------------");

        DragonRaja.school="卡塞尔学院";

        Student_Chu chu=new Student_Chu();
        chu.setName("楚子航");
        chu.setSex("男");
        chu.setAge(26);
        chu.Welcome();
        chu.Quotation();

        System.out.println("-----------------------------------");

        student_Lu Lu=new student_Lu();
        Lu.setName("路明非");
        Lu.setSex("男");
        Lu.setAge(24);
        Lu.Welcome();
        Lu.Quotation();
    }
}
