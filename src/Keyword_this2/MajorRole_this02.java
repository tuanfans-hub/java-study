package Keyword_this2;
    //使用this关键字调用本类中的成员变量

public class MajorRole_this02 {
    public void Method01(){
        System.out.println("------Method01------");
        this.Method02();//调用的是本类中其他的成员方法，this可以省略，即Method02();
    }
    public void Method02(){
        System.out.println("------Method02------");
    }
}
