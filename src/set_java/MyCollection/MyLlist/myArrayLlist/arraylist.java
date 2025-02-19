package set_java.MyCollection.MyLlist.myArrayLlist;

import java.util.ArrayList;

/**
 * ArrayList的扩容机制：
 * 利用空参创建的集合，在底层创建一个默认长度为0的数组
 * 添加第一个元素时，底层会创建一个新的长度为10的数组
 * 存满时，会扩容1.5倍
 * 如果一次添加多个元素，1.5倍还放不下，则新创建数组的长度以实际为准
 * */
public class arraylist {
    public static void main(String[] args){
        //创建集合
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("ddd");
        list1.add("eee");

        //添加多个元素
        ArrayList<String> list2 = new ArrayList<>();
        list2.addAll(list1);
        System.out.println(list2);
        list2.addAll(2,list1);  //指定添加元素的其实位置
        System.out.println(list2);
    }
}
