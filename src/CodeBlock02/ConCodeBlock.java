package CodeBlock02;
//构造代码块：直接在类中定义的代码块

public class ConCodeBlock {
    {
        System.out.println("构造代码块已执行...");
    }
    //构造代码块在构造方法之前执行

    public ConCodeBlock(){
        System.out.println("无参构造方法已执行...");
    }
    public ConCodeBlock(int age){
        System.out.println("有参构造方法已执行...");
    }
}
