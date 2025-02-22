package set_java.MyCollection.MySet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

/**
 * 利用Set系列的集合，添加字符串，并使用多种方式遍历：迭代器、增强for、Lambda表达式
 *
 * 1．Set系列集合的特点：
 *  无序、不重复、无索引
 *  Set集合的方法上基本上与Collection的APl一致
 * 2.Set集合的实现类特点：
 *  HashSet：无序、不重复、无索引
 *  LinkedHashSet：有序、不重复、无索引l
 *  TreeSet：可排序、不重复、无索引
 * */
public class mySet {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();

        set.add("java");
        set.add("C");
        set.add("C#");
        set.add("C++");
        set.add("python");

        //迭代器遍历
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(it.hasNext()){
                System.out.print(s+",");
            }else{
                System.out.println(s);
            }
        }

        //Set集合的add方法是有返回值的
        System.out.println(set.add("java"));//set集合不允许重复元素，所以添加相同的元素时，添加失败，返回false
        System.out.println(set.add("html"));//添加新元素时，添加成功，返回true
        //增强for循环遍历
        for(String s:set){
            System.out.print(s+",");
        }
        System.out.println();

        //Lambda表达式遍历
        set.forEach(s -> System.out.print(s+","));
        System.out.println();

        //匿名内部类方式
        set.forEach(new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.print(s+",");
            }
        });

    }
}
