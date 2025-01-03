package api;
/*自己实现parseInt方法，将字符串类型的整数转换为int类型
* 要求如下：
* 字符串内不能有除数字外其他字符
* 最少1位，最多10位
* 0不能作为字符串的开头
* */
public class api_test2 {
    public static void main(String[] args) throws Exception {
        System.out.println(rewriteParseInt("123456789")-1);
        System.out.println(rewriteParseInt("abs")-1);
    }

    public static int rewriteParseInt(String input) throws Exception {
        int result = 0;
        if(input.matches("[1-9]\\d{0,9}")){
            for (int i = 0; i < input.length(); i++) {
                int c = input.charAt(i)-'0';
                result = result * 10 + c;
            }
        }else{
            throw new Exception("格式错误！");
        }
        return result;
    }
}
