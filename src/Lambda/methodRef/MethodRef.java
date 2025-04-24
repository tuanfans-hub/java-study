package Lambda.methodRef;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description 方法引用
 */
public class MethodRef {
    public static void main(String[] args) {
        //创建一个数组，进行倒序排列
        //匿名内部类
        Integer[] array1 = {3,5,4,1,6,2};
        Arrays.sort(array1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(array1));
        //lambda表达式
        Integer[] array2 = {3,5,4,1,6,2};
        Arrays.sort(array2,(o1,o2)->o2-o1);
        System.out.println(Arrays.toString(array2));
        //方法引用
        //方法引用的条件：
        //1.引用处必须是函数式接口
        //2.被引用的方法必须已经存在
        //3.被引用方法的形参和返回值，需要跟抽象方法保持一致
        //4.被引用方法的功能要满足当前需求
        Integer[] array3 = {3,5,4,1,6,2};
        Arrays.sort(array3,MethodRef::subtraction);
        System.out.println(Arrays.toString(array3));
    }

    private static int subtraction(int a,int b){
        return b-a;
    }
}
