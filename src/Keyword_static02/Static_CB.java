package Keyword_static02;
/*
*静态代码块：当类加载时，静态代码块会执行，由于类只加载一次，因此静态代码块只执行一次
* */
public class Static_CB {

    static{
        System.out.println("《魔道祖师》");
    }//静态代码块
}
