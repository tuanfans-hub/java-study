package set_java.MyMap.MyHashtable;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author TuanFans
 * &#064;date 2025/3/10
 */
/*
HashTable的基本介绍
1）存放的元素是键值对：即K-V
2)hashtable的键和值都不能为null，否则会抛出NullPointerException
3)hashTable使用方法基本上和HashMap一样
4)hashTable是线程安全的（synchronized），hashMap是线程不安全的
* */
public class MyHashTable {
    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("南昌","江西");
        map.put("赣州","江西");
        map.put("九江","江西");
        map.put("上饶",null); //键能为null，值可以为null
        map.put(null,"北京");
        System.out.println(map);

        // Hashtable的底层逻辑
        // Hashtable的底层是数组+链表，数组是Hashtable的成员变量，数组的类型是Entry[]，数组的长度是11，默认是11
        // 负载因子：0.75
        // 扩容：当数组的容量达到0.75*数组长度时，数组扩容，默认扩容为原来的2倍+1，即数组长度为2*11+1=23
        Hashtable<String,String> table = new Hashtable<>();
        table.put("南昌","江西");
        table.put("赣州","江西");
        table.put("九江","江西");
        table.put("上饶","江西");
        table.put("上饶1","江西");
        table.put("上饶2","江西");
        table.put("上饶3","江西");
        table.put("上饶4","江西");
        table.put("上饶5","江西");
        table.put("上饶6","江西");
        table.put("上饶7","江西");
        table.put("上饶8","江西");
        table.put("上饶9","江西");
        table.put("上饶10","江西");
        table.put("上饶11","江西");

//        table.put("上饶",null);
//        table.put(null,"北京"); 键和值都不能为null，会抛出NullPointerException
        System.out.println(table);

        System.out.println("------------------------------------");

    }
}
