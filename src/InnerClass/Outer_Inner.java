package InnerClass;

public class Outer_Inner {
    int a=10;

    class Inner{
        int a=20;

        public void print(){
            int a=30;
            System.out.println(a);//就近原则~最终输出：30
            System.out.println(this.a);//this访问调用者所在类地址~最终输出：20
            System.out.println(Outer_Inner.this.a);//Outer_Inner.this获取外部类Outer_Inner的地址值~最终输出：10
        }
    }
}
