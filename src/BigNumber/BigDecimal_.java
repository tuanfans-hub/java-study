package BigNumber;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Formatter;

/**
 * @author TuanFans
 * &#064;date 2025/3/8
 */
public class BigDecimal_ {
    public static void main(String[] args){
//        double d = 3.1415925535897932384626433832795D;
//        System.out.println(d);    会发生精度缩减
        //当需要一个较大精度的数字时，应该使用BigDecimal类
        BigDecimal bd = new BigDecimal("3.1415925535897932384626433832795");
        System.out.println("bd："+bd);

        // 如果对BigDecimal进行运算，则需要使用其提供的对应的方法
        // 对BigDecimal进行加减乘除运算时，必须使用对应的方法，不能直接使用运算符进行计算
        // 加法运算
        BigDecimal bd_add = bd.add(new BigDecimal("1"));
        System.out.println("bd_add(bd+1)："+bd_add);
        // 减法运算
        BigDecimal bd_subtract = bd.subtract(new BigDecimal("1"));
        System.out.println("bd_subtract(bd-1)："+bd_subtract);
        // 乘法运算
        BigDecimal bd_multiply = bd.multiply(new BigDecimal("10"));
        System.out.println("bd_multiply(bd*10)："+bd_multiply);
        // 除法运算
        BigDecimal bd_divide = bd.divide(new BigDecimal("3"),3, RoundingMode.CEILING);
        // 可能抛出异常：ArithmeticException: Non-terminating decimal
        // 解决方案：在调用divide()方法时，指定一个精度参数，表示保留几位小数 或 指定舍入类型
        // 在JDK 9中，BigDecimal.ROUND_CEILING等舍入模式常量被标记为废弃（deprecated）
        // 推荐使用新的RoundingMode枚举类来替代。
        System.out.println("bd_divide(bd/10)："+bd_divide);
    }
}
