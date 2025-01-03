package Inter_face;

public class InterA_Test {
    public static void main(String[] args) {
        InterImpl Lu=new InterImpl();
        System.out.print(Lu.name+",");
        Lu.Sex();
        InterA.age();
        Lu.show();
    }
}
