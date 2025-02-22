package set_java.MyCollection.MySet.TreeSet;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * TreeSet的特点:
 * 不重复、无索引、可排序
 * 可排序：按照元素的默认规则（有小到大）排序。
 * TreeSet集合底层是基于红黑树的数据结构实现排序的，增删改查性能都较好。
 *
 * TreeSet集合默认的规则：
 * 对于数值类型：Integer，Double，默认按照从小到大的顺序进行排序。
 * 对于字符、字符串类型：按照字符在ASCII码表中的数字升序进行排序。
 * */
public class treeSet {
    public static void main(String[] args){
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(15);
        ts.add(46);
        ts.add(13);
        ts.add(32);
        ts.add(30);

        //迭代器遍历
        Iterator<Integer> it = ts.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

        //增强for循环
        for(Integer i : ts){
            System.out.print(i+" ");
        }
        System.out.println();

        //Lambda表达式遍历
        ts.forEach(i -> System.out.print(i+" "));
        System.out.println();

        //匿名内部类实现
        ts.forEach(new Consumer<Integer>(){

            @Override
            public void accept(Integer i) {
                System.out.print(i+" ");
            }
        });

    }
}
