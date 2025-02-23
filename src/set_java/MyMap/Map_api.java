package set_java.MyMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * V put(K key,V value)                 添加元素
 * V remove(object key)                 根据键册除键值对元素
 * void clear()                         移除所有的键值对元素
 * boolean containsKey(object key)      判断集合是否包含指定的键
 * boolean containsValue(Object value)  判断集合是否包含指定的值
 * boolean isEmpty()                    判断集合是否为空
 * int size()                           集合的长度，也就是集合中键值对的个数
 * */
public class Map_api {
    public static void main(String[] args){
        //创建Map集合对象
        Map<String,String> map = new HashMap<>();

        //添加元素
        //put方法：添加/覆盖元素
        //如果键不存在，则添加元素，返回null
        //如果键存在，则覆盖元素，并返回被覆盖的值
        map.put("南昌","江西");
        map.put("赣州","江西");
        map.put("泉州","福建");
        map.put("珠海","广东");
        System.out.println(map);
        System.out.println(map.put("南昌", "福建"));;
        System.out.println(map);
        System.out.println("------------------------------------");
        //删除元素
        //remove方法：根据键删除键值对元素
        //如果键存在，则删除元素，并返回被删除的值
        //如果键不存在，则返回null
        System.out.println(map.remove("南昌"));
        System.out.println(map);
        System.out.println("------------------------------------");
        //containsKey方法：判断集合是否包含指定的键
        //如果存在指定的键，返回true
        //如果不存在，返回false
        System.out.println(map.containsKey("泉州"));
        System.out.println(map.containsKey("南昌"));
        System.out.println("------------------------------------");
        //containsValue方法：判断集合是否包含指定的值
        //如果存在指定的值，返回true
        //如果不存在，返回false
        System.out.println(map.containsValue("福建"));
        System.out.println(map.containsValue("北京"));
        System.out.println("------------------------------------");
        //size方法：集合的长度，也就是集合中键值对的个数
        System.out.println(map.size());
        System.out.println("------------------------------------");
        //isEmpty方法：判断集合是否为空
        //如果集合为空，放回true；否则返回false
        System.out.println(map.isEmpty());
        System.out.println("------------------------------------");
        //clear方法：移除所有的键值对元素
        map.clear();
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println("------------------------------------");
        System.out.println("map集合的遍历：");
        map.put("南昌","江西");
        map.put("赣州","江西");
        map.put("泉州","福建");
        map.put("珠海","广东");
        //map遍历方式
        //1.键找值
        //获取所有的键，并将其放到一个单列集合中
        System.out.println("-----------1.键找值-------------");
        Set<String> keys = map.keySet();
        //增强for循环
        for(String k : keys){
            System.out.print(k+"="+map.get(k)+" ");
        }
        System.out.println();

        //迭代器遍历
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.print(key+"="+map.get(key)+" ");
        }
        System.out.println();

        //Lambda表达式遍历
        keys.forEach(key -> System.out.print(key+"="+map.get(key)+" "));
        System.out.println();

        //匿名内部类实现
        keys.forEach(new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.print(s+"="+map.get(s)+" ");
            }
        });
        System.out.println();

        //2.键值对
        System.out.println("------------2.键值对------------");
        //获取所有的键值对，并将其放到一个单列集合中
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //增强for循环
        for(Map.Entry<String,String> e : entries){
            System.out.print(e.getKey()+"="+e.getValue()+" ");
        }
        System.out.println();

        //迭代器遍历
        Iterator<Map.Entry<String,String>> it2 = entries.iterator();
        while(it2.hasNext()){
            Map.Entry<String,String> e = it2.next();
            System.out.print(e.getKey()+"="+e.getValue()+" ");
        }
        System.out.println();

        //Lambda表达式遍历
        entries.forEach(e -> System.out.print(e.getKey()+"="+e.getValue()+" "));
        System.out.println();

        //匿名内部类实现
        entries.forEach(new Consumer<Map.Entry<String,String>>(){

            @Override
            public void accept(Map.Entry<String, String> e) {
                System.out.print(e.getKey()+"="+e.getValue()+" ");
            }
        });
        System.out.println();

        //3.Lambda表达式
        System.out.println("------------3.Lambda表达式------------");
        map.forEach((k,v)-> System.out.print(k+"="+v+" "));
        System.out.println();

        //4.匿名内部类实现
        map.forEach(new BiConsumer<String,String>(){
            @Override
            public void accept(String key, String value) {
                System.out.print(key+"="+value+" ");
            }
        });
        System.out.println();

    }
}
