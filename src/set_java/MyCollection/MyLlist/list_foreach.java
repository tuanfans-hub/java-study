package set_java.MyCollection.MyLlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * List系列集合的五种遍历方式：
 * 1.迭代器
 * 2.列表迭代器
 * 3.增强for
 * 4.Lambda表达式
 * 5.普通for循环
 * */
public class list_foreach {
    public static void main(String[] args){
        List<String> list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");

        //1.迭代器遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(it.hasNext()){
                System.out.print(s+",");
            }else{
                System.out.println(s);
            }
        }

        //2.增强for循环
        for(String s:list){
            if(list.get(list.size()-1)==s){
                System.out.println(s);
            }else{
                System.out.print(s+",");
            }
        }

        //3.Lambda表达式遍历
        //3.1匿名内部类实现
            //forEach方法的底层其实就是一个循环遍历，依次得到集合中的每一个元素
            //并把每一个元素传递给下面的accept方法
            //accept方法的形参s，依次表示集合中的每一个元素
        list.forEach(new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.print(s+",");
            }
        });
        System.out.println();
        //3.2lambda表达式实现
            //Consumer是一个函数式接口，只有一个抽象方法accept，可以用lambda表达式实现
        list.forEach(s -> System.out.print(s+","));
        System.out.println();

        //4.普通for循环
        int i = 0;
        for(;i<list.size()-1;i++){
            System.out.print(list.get(i)+",");
        }
        System.out.println(list.get(i));

        //5.列表迭代器
        //ListIterator是Iterator的子接口，只能用于List集合，可以实现逆向遍历
        //ListIterator可以实现对集合元素的增删改查操作
        //注意：在列表迭代器遍历集合的过程中，不能使用集合的方法对集合进行增删操作，否则会报错
        //即使是进行了增删操作，最终遍历结果还是增删前的结果
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            if(s.equals("bbb")){
                iterator.add("java");
            }
            if(iterator.hasNext()){
                System.out.print(s+",");
            }else{
                System.out.println(s);
            }
        }
        System.out.println(list);
    }
}
