package regex;
//正则表达式：捕获分组和非捕获分组
//分组就是一个小括号
public class group1 {
    //判断字符串的起始字符与结束字符是否一致
    public static void main(String[] args){
        //只考虑一个字符
        String regex1 = "(.).+\\1";/*\\组号：表示把所对应的组号字符搬过来*/
        System.out.println("a123a".matches(regex1));//true

        //考虑多个字符
        String regex2 = "(.+).+\\1";
        System.out.println("abc123abc".matches(regex2));//true

        //起始字符内部的字符也需一致
        String regex3 = "((.)\\2*).+\\1";
        System.out.println("abc123abc".matches(regex3));//false
        System.out.println("aaa123aaa".matches(regex3));//true
    }
}
