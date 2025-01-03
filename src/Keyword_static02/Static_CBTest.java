package Keyword_static02;

public class Static_CBTest {
    public static void main(String[] args){
        Static_CB title01=new Static_CB();
        Static_CB title02=new Static_CB();
        //虽然创建了两次对象，但是静态代码块只执行一次
    }
}
