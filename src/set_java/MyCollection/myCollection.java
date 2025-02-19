package set_java.MyCollection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * public boolean add(E e)添加
 * public void clear()清空
 * public boolean remove(E e)删除
 * public boolean contains（Object obj）判断是否包含
 * public boolean isEmpty()判断是否为空
 * public int size()集合长度
 * */
public class myCollection {
    public static void main(String[] args){
        Collection<String> coll= new ArrayList<>();

        //add():添加元素
        //细节1：如果我们要往List系列集合中添加数据，那么方法永远返回true，因为List系列的是允许元素重复的。
        //细节2：如果我们要往Set系列集合中添加数据，如果当前要添加元素不存在，方法返回true，表示添加成功。
        //                                   如果当前要添加的元素已经存在，方法返回false，表示添加失败。
        //                                   因为Set系列的集合不允许重复。
        coll.add("abc");
        coll.add("opq");
        coll.add("xyz");
        System.out.println(coll);

        //clear():清空
        coll.clear();
        System.out.println(coll);

        //remove():删除,不能通过索引删除
        //返回值：
        //删除成功，返回true；删除失败，返回false。
        coll.add("abc");
        coll.add("opq");
        coll.add("xyz");
        coll.remove("abc");
        System.out.println(coll);

        //contains():判断是否包含
        //细节：底层是依赖equals方法进行判断是否存在的。
        //所以，如果集合中存储的是自定义对象，也想通过contains()方法来判断是否包含，那么在javabean类中，一定要重写equals方法
        System.out.println(coll.contains("opq"));
        System.out.println(coll.contains("abc"));

        //isEmpty():判断是否为空
        System.out.println(coll.isEmpty());

        //size():集合长度
        System.out.println(coll.size());

    }
}
