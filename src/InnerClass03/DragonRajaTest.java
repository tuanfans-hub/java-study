package InnerClass03;

public class DragonRajaTest {
    public static void main(String[] args){
        DragonRaja.Student stu=new DragonRaja.Student();
        DragonRaja.name="诺诺";
        stu.age=20;
        stu.show();

        DragonRaja.Student.show2();
    }
}
