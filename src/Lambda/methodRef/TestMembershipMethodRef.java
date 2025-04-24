package Lambda.methodRef;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description 成员方法引用
 */
public class TestMembershipMethodRef {
    @Test
    public void testMMR(){
        //成员方法引用
        //格式：对象::成员方法名
        //1.本类引用：this::方法名
        //2.父类引用：super::方法名
        //3.其他类引用：其他类对象::方法名
        //4.使用类名引用：类名::成员方法名

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"123","45","6789","0","789");
        //过滤掉字符串长度不等于3的元素
        //list.stream().filter(s->s.length()==3).forEach(System.out::println);
        //匿名内部类实现
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()==3;
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
        System.out.println();

        //方法引用的条件：
        //1.引用处必须是函数式接口
        //2.被引用的方法必须已经存在
        //3.被引用方法的形参和返回值，需要跟抽象方法保持一致
        //4.被引用方法的功能要满足当前需求

        //方法引用实现(其他类)
        list.stream().filter(new TestRef()::testFilter).forEach(new TestRef()::print);
        System.out.println();
        //方法引用实现(本类)
        list.stream().filter(this::t_filter).forEach(this::t_print);
        System.out.println();
    }

    public boolean t_filter(String str){
        return str.length()==3;
    }

    public void t_print(String str){
        System.out.print(str+" ");
    }

    @Test
    public void testMMRByClass(){
        //集合里面一些字符串，要求变成大写后进行输出
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"sdfds","adsf","weioj","mcnvo");
        List<String> upperList1 = list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).collect(Collectors.toList());
        System.out.println(upperList1);

        //String::toUpperCase->类名引用成员方法
        //不能引用所有类中的成员方法
        //如果抽象方法的第一个参数是A类型的，只能引用A类中的方法
        List<String> upperList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperList);
    }

}
