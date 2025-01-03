package regex;
/*
* 非捕获分组：
* 分组之后不再使用本组数据，仅仅把数据括起来
* (?:正则)：获取所有
* (?=正则)：获取前面的内容
*(?!正则)：获取不是指定内容的前面部分
* */
public class group3 {
    public static void main(String[] args){
        //简易身份证正则表达式
        String regex = "[1-9]\\d{16}(?:\\d|x|X)";//(?:\d|x|X)该分组将无法被其他地方使用
        System.out.println("36073120040516795x".matches(regex));
    }
}
