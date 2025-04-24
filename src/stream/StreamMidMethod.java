package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description Stream流的中间方法
 */
public class StreamMidMethod {
    public static void main(String[] args) {
        //注意1：中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
        //注意2：修改stream流中的数据，不会影响原来集合或者数组中的数据
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "熊大","熊二","张三", "李四", "王五", "赵六", "孙七","张无忌", "赵四", "王五", "赵六", "孙七");
        System.out.println("names:");
        names.forEach(s-> System.out.print(s+" "));
        System.out.println();
        //Stream<T> filter(Predicate<? super T> predicate)过滤
        System.out.println("filter():");
        // filter(Predicate<? super T> predicate)过滤
        // 匿名内部类实现
        names.stream().filter(new Predicate<String>(){
            @Override
            public boolean test(String s) {
                // 返回true表示留下，返回false表示删除
               return s.startsWith("张");
            }
        }).forEach(new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
        System.out.println();
        // lambda表达式，过滤出姓张的人
        names.stream().filter(s->s.startsWith("张")).forEach(s-> System.out.print(s+" "));
        System.out.println();
        //Stream<T> limit(long maxSize)获取前几个元素
        System.out.println("limit():");
        names.stream().limit(4).forEach(s-> System.out.print(s+" "));
        System.out.println();
        // Stream<T> skip(long n)跳过前几个元素
        System.out.println("skip():");
        names.stream().skip(4).forEach(s-> System.out.print(s+" "));
        System.out.println();
        // Stream<T> distinct()元素去重，依赖(hashcode和equals方法)：如果是自定义类，重写hashCode和equals方法
        // 底层通过hashSet实现元素去重
        System.out.println("distinct():");
        names.stream().distinct().forEach(s-> System.out.print(s+" "));
        System.out.println();
        //static <T> Stream<T> concat(Stream a, Stream b)合并a和b两个流为一个流
        System.out.println("concat():");
        Stream.concat(names.stream(), Stream.of("毛毛", "吉吉", "光头强", "赵琳", "蹦蹦"))
                .forEach(s-> System.out.print(s+" "));
        System.out.println();
        //Stream<R> map(Function<T,R> mapper)转换流中的数据类型
        System.out.println("map():");
        names.stream().map(s->s.hashCode()).forEach(s-> System.out.print(s+" "));
        System.out.println();
        names.stream().map(s->s.length()).forEach(s-> System.out.print(s+" "));
        System.out.println();
        ArrayList<String> persons = new ArrayList<>();
        Collections.addAll(persons, "熊大-20","熊二-19","张三-25", "李四-40", "王五-30", "赵六-27", "孙七-60","张无忌-50", "赵四-32", "王五-30", "赵六-27", "孙七-60");
        System.out.println("map():");
        System.out.println("persons:");
        persons.forEach(s-> System.out.print(s+" "));
        System.out.println();
        // 匿名内部类实现
        persons.stream().map(new Function<String,Integer>(){
            @Override
            public Integer apply(String s) {
                String[] split = s.split("-");// split(): 将字符串根据指定的分隔符进行分割，返回一个数组
                Integer age = Integer.parseInt(split[1]);
                return age;
            }
        }).forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });
        System.out.println();
        // lambda表达式实现
        persons.stream().map(s->Integer.parseInt(s.split("-")[1]))
                .forEach(s-> System.out.print(s+" "));
        System.out.println();
    }
}
