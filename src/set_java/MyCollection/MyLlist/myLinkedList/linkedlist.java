package set_java.MyCollection.MyLlist.myLinkedList;

import java.util.LinkedList;

/**
 * 底层数据结构是双链表，查询慢，首尾操作的速度是极快的，所以多了很多首尾操作的特有API。
 * public void addFirst(E e)在该列表开头插入指定的元素
 * public void addLast(E e)将指定的元素追加到此列表的末尾
 * public E getFirst()返回此列表中的第一个元素
 * public E getLast()返回此列表中的最后一个元素
 * public E removeFirst()从此列表中删除并返回第一个元素
 * public E removeLast()从此列表中删除并返回最后一个元素
 * */
public class linkedlist {
    public static void main(String[] args){
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("ddd");
        list1.add("eee");

        System.out.println(list1);

        //public void addFirst(E e)在该列表开头插入指定的元素
        list1.addFirst("java");
        System.out.println(list1);
    }
}
