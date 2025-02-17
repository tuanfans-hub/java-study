package Lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Lambda表达式的运用
 * Lambda的格式：
 * (参数)->{
 *     方法体
 * }
 * 其中()表示方法的参数，{}表示方法体
 * 如果方法体中只有一条语句，可以省略{}
 *
 * Lambda表达式可以用来简化匿名内部类的书写
 * Lambda表达式只能简化函数式接口的匿名内部类的写法
 * 函数式接口：有且仅有一个抽象方法的接口叫做函数式接口，接口上方可以加@Functionallnterface注解
 *
 * lambda的省略规则：
 * 核心：可推导的，可省略
 * 1.参数类型可以省略不写。
 * 2.如果只有一个参数，参数类型可以省略，同时()也可以省略。
 * 3.如果Lambda表达式的方法体只有一行，大括号，分号，return可以省略不写，需要同时省略。
 * */

public class lambda {
    public static void main(String[] args){
        Integer[] array1 = {2,5,8,9,6,3,1,4,7,10};
        Integer[] array2 = {2,5,8,9,6,3,1,4,7,10};
        Integer[] array3 = {2,5,8,9,6,3,1,4,7,10};

         //利用匿名内部类实现接口实例化
        System.out.println("------------Lambda1--------------");
        System.out.println("----------匿名内部类实现------------");
         Arrays.sort(array1, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
             return o2-o1;   //降序排列
         }
         });
        System.out.println(Arrays.toString(array1));
        System.out.println("---------Lambda表达式实现----------");
        Arrays.sort(array2,(Integer o1,Integer o2)->{
            return o2-o1;
        });
        System.out.println(Arrays.toString(array2));
        System.out.println("-------Lambda表达式省略规则---------");
        Arrays.sort(array3,(o1,o2)->o2-o1);
        System.out.println(Arrays.toString(array3));


        System.out.println("\n------------Lambda2--------------");
        System.out.println("----------匿名内部类实现------------");
        method(new la_Swim(){
            @Override
            public void swimming(){
                System.out.println("游泳-ing~~~~~~");
            }
        });

        System.out.println("---------Lambda表达式实现----------");
        method(()->{
            System.out.println("游泳-ing~~~~~~");
        });

        System.out.println("-------Lambda表达式省略规则---------");
        method(()->System.out.println("游泳-ing~~~~~~"));

    }

    public static void method(la_Swim s){
        s.swimming();
    }
}
