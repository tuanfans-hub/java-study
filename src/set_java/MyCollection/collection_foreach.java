package set_java.MyCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * collection系列集合三种通用的遍历方式：
 * 1.迭代器遍历
 * 2.增强for遍历
 * 3.lambda表达式遍历
 *
 * 迭代器遍历相关的三个方法：
 * Iterator<E> iterator()）：获取一个迭代器对象
 * boolean hasNext()：判断当前指向的位置是否有元素
 * E next()：获取当前指向的元素并移动指针
 * */
public class collection_foreach {
    public static void main(String[] args){
        //创建集合并添加元素
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");
        coll.add("eee");

        //使用迭代器遍历
        //获取迭代器对象，默认指向起始位置
        Iterator<String> it = coll.iterator();
        while(it.hasNext()){    //hasNext():判断迭代器对象指向的位置是否有元素
            String s = it.next();//next():获取当前迭代器对象指向的位置的元素，并移动指针；每次循环只能使用一次该方法
            //迭代器遍历时，不能用集合的方法进行增删，否则会出现ConcurrentModificationException异常
            if(s.equals("ccc")){
                it.remove();//迭代器遍历时，可以使用迭代器的remove方法删除元素，删除的是迭代器指向的元素
            }
            if(it.hasNext()){
                System.out.print(s+",");
            }else{
                System.out.println(s);
            }
        }   //迭代器遍历完毕，指针不会复位

        //使用增强for遍历
        //增强for的底层就是迭代器，为了简化迭代器的代码书写的。
        //所有的单列集合和数组才能用增强for进行遍历。
        //修改增强for中的变量，不会改变集合中原本的数据。
        for(String s:coll){
            System.out.print(s+",");
        }
        System.out.println();

        //匿名内部类实现遍历
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+",");
            }
        });
        System.out.println();

        //Lambda表达式遍历
        coll.forEach(s -> System.out.print(s+","));

    }
}
