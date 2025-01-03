package InnerClass;

public class Test_Outer_Inner {
    public static void main(String[] args){
        Outer_Inner.Inner oi = new Outer_Inner().new Inner();
        System.out.println(oi.a);//20
        System.out.println("----");
        oi.print();

    }
}
