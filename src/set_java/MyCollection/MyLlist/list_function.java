package set_java.MyCollection.MyLlist;

import java.util.ArrayList;
import java.util.List;

/**
 * List系列集合独有的方法：
 * void add(int index,E element)在此集合中的指定位置插入指定的元素
 * E remove(int index)删除指定索引处的元素，返回被删除的元素
 * E set(int index,E element)修改指定索引处的元素，返回被修改的元素
 * E get(int index)返回指定索引处的元素
 * */
public class list_function {
    public static void main(String[] args) {
        //创建一个集合
        List<String> list = new ArrayList();
        //添加元素
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        System.out.println("起始集合：\t\t\t"+list);

        //List系列集合独有方法
        //1.void add(int index,E element)在此集合中的指定位置插入指定的元素
        list.add(1,"java");
        System.out.println("add(1,\"java\"):\t\t"+list);

        //2.E remove(int index)删除指定索引处的元素，返回被删除的元素
        list.remove(0); //返回"aaa"
        System.out.println("remove(0):\t\t\t"+list);

        //3.E set(int index,E element)修改指定索引处的元素，返回被修改的元素
        list.set(1,"python");   //返回"bbb"
        System.out.println("set(1,\"python\"):\t"+list);

        //4.E get(int index)返回指定索引处的元素
        list.get(2);   //返回"ccc"
        System.out.println("get(2):\t\t\t\t"+list);

    }
}
