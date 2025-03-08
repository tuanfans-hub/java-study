package BigNumber;

import Annotation.UseCase;

import java.math.BigInteger;

/**
 * @author TuanFans
 * &#064;date 2025/3/8
 */
public class BigInteger_ {
    public static void main(String[] args){
        // long l = 123456789101112131415161718L;    报错：长整数过大
        // 当编程中要处理很大的整数，可以使用BigInteger类
        BigInteger bi = new BigInteger("123456789101112131415161718");
        System.out.println("bi："+bi);
        // 对BigInteger进行加减乘除运算时，必须使用对应的方法，不能直接使用运算符进行计算
        // 加法运算
        BigInteger bi_add = bi.add(new BigInteger("1"));
        System.out.println("bi_add(bi+1)："+bi_add);
        // 减法运算
        BigInteger bi_subtract = bi.subtract(new BigInteger("1"));
        System.out.println("bi_subtract(bi-1)："+bi_subtract);
        // 乘法运算
        BigInteger bi_multiply = bi.multiply(new BigInteger("10"));
        System.out.println("bi_multiply(bi*10)："+bi_multiply);
        // 除法运算
        BigInteger bi_divide = bi.divide(new BigInteger("10"));
        System.out.println("bi_divide(bi/10)："+bi_divide);  //计算结果是整数，所以会丢失小数部分，不会四舍五入
    }

}
