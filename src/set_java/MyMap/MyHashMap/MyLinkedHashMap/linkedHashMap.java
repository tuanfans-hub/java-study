package set_java.MyMap.MyHashMap.MyLinkedHashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap:
 * 由键决定：有序、不重复、无索引。
 * 这里的有序指的是保证存储和取出的元素顺序一致
 * 原理：底层数据结构是依然哈希表，只是每个键值对元素又额外的多了一个双链表的机制记录存储的顺序。
 * */
public class linkedHashMap {
    public static void main(String[] args){
        System.out.println("---------LinkedHashMap---------");
        LinkedHashMap<String,String> lMap = new LinkedHashMap<>();
        //添加元素
        lMap.put("南昌","江西");
        lMap.put("赣州","江西");
        lMap.put("泉州","福建");
        lMap.put("珠海","广东");
        lMap.put("深圳","广东");

        System.out.println(lMap);

        //遍历集合
        //有序：按照添加元素的顺序取出元素
        //增强for循环-键值对
        Set<Map.Entry<String,String>> lMap_set = lMap.entrySet();
        for(Map.Entry<String,String> ls : lMap_set){
            System.out.println(ls.getKey()+"-->"+ls.getValue());
        }

        System.out.println("--------------------");
        //迭代器遍历-键找值
        Set<String> lMap_keys = lMap.keySet();
        Iterator<String> it = lMap_keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = lMap.get(key);
            System.out.println(key+"-->"+value);
        }

        System.out.println("--------------------");
        //Lambda表达式遍历-键值对
        lMap.forEach((key,value)-> System.out.println(key+"-->"+value));

    }
}
