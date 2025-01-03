package regex;
/*
* 捕获分组
* 后续还要继续使用本组数据：
* 正则表达式内部：\\
* 正则表达式外部：$
* */
public class group2 {
    //口吃替换：将字符串：我爱学学学编编编编编编编编程程程程程程  替换为：我爱学编程
    public static void main(String[] args){
        String str = "我爱学学学编编编编编编编编程程程程程程";
        String reStr=str.replaceAll("(.)\\1+","$1");
        System.out.println(reStr);
    }
}
