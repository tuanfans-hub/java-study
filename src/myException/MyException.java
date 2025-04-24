package myException;

public class MyException extends Exception{
    //1．异常是程序中可能出现的问题
    //2．异常体系的最上层父类是Exception;
    // 异常分为两类：编译时异常、运行时异常
    //3.编译时异常和运行时异常的区别？
    //编译时异常：没有继承RuntimeException的异常，直接继承于Exception。编译阶段就会错误提示
    //运行时异常：RuntimeException本身和子类。编译阶段没有错误提示，运行时出现的
    public MyException(){
    }

    public MyException(String message) {
        super(message);
    }
}
