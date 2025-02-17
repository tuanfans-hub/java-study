package Lambda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Lambda表达式练习：
 * Lambda表达式简化comparator接口的匿名形式
 * 定义数组并存储一些字符串，利用Arrays中的sort方法进行排序
 * 要求：
 * 按照字符串的长度进行排序，短的在前面，长的在后面。
 * */
public class lambdaPractice {
    public static void main(String[] args){
        //获取数组
        String[] array = getArray();
        System.out.println("排序前数组："+ Arrays.toString(array));

        //对数组进行排序
        Arrays.sort(array,(s1, s2)->
                s1.length()!=s2.length()?s1.length()-s2.length():s1.compareTo(s2)
                );
        System.out.println("排序后数组："+Arrays.toString(array));

    }

    public static String[] getArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----添加字符串数组元素-----");
        System.out.print("数组长度：");
        int length = sc.nextInt();
        String[] array = new String[length];
        //添加元素
        for(int i = 0; i < length; i++){
            System.out.print("array["+i+"]=");
            array[i] = sc.next();
        }

        return array;
    }
}
