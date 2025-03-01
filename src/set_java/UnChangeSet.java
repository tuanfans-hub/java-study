package set_java;

import java.util.*;

public class UnChangeSet {
    public static void main(String[] args){
        /*
        * 创建不可变集合的书写格式:
        * 在List、Set、Map接口中，都存在静态的of方法，可以获取一个不可变的集合。
        * static <E> List<E> of(E...elements)   创建一个具有指定元素的List集合对象
        * static <E> Set<E> of(E...elements)    创建一个具有指定元素的Set集合对象
        * static <K, V> Map<K, V> of(E...elements)  创建一个具有指定元素的Map集合对象
        *
        * 注意：这个不可变集合不能添加，不能删除，不能修改，只能查询。
        * */

        //一旦创建无法修改
        List<String> list = List.of("张三","李四","王五","赵六");
        System.out.println(list);
        // list.add("赵六");   报错信息：UnsupportedOperationException
        System.out.println("--------------------------------------------");
        Set<String> set = Set.of("张三","李四","王五","赵六");
        //Set<String> set1 = Set.of("张三","李四","王五","赵六","赵六");  set集合具有不可重复性，所以不能有重复元素。报错信息：IllegalArgumentException
        System.out.println(set);
        System.out.println("--------------------------------------------");
        //Map.of()内的参数上限为20，所以参数的个数不能超过20，即最多10个键值对
        //如果参数的键值对个数超过10，则可以使用Map.ofEntries()方法
        Map<String, String> map = Map.of("赣州", "南昌",
                "九江", "南昌",
                "长沙", "湖南",
                "厦门", "福建",
                "珠海", "广东",
                "伊犁", "新疆",
                "台北", "台湾");
        System.out.println(map);

        //遍历Map集合
        System.out.println("---------增强for遍历---------");
        Set<String> keys = map.keySet();
        for(String key : keys){
            String value = map.get(key);
            System.out.println(key+"="+value);
        }
        System.out.println("---------迭代器遍历----------");
        //迭代器遍历
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        System.out.println("------Lambda表达式遍历-------");
        //Lambda表达式遍历
        Set<Map.Entry<String,String>> e = map.entrySet();
        e.forEach(en-> System.out.println(en.getKey()+"="+en.getValue()));
        System.out.println("--------------------------------------------");
        Map<String,String> map1 = Map.ofEntries(
                Map.entry("赣州","南昌"),
                Map.entry("九江","南昌"),
                Map.entry("长沙","湖南"),
                Map.entry("厦门","福建"),
                Map.entry("珠海","广东"),
                Map.entry("伊犁","新疆"),
                Map.entry("台北","台湾"),
                Map.entry("福州","福建"),
                Map.entry("沈阳","辽宁"),
                Map.entry("大连","辽宁"),
                Map.entry("哈尔滨","黑龙江"),
                Map.entry("长春","吉林")
        );
        System.out.println(map1);
        System.out.println("--------------------------------------------");
        //创建一个普通的集合
        HashMap<String,String> hm = new HashMap<>();
        hm.put("赣州","南昌");
        hm.put("九江","南昌");
        hm.put("长沙","湖南");
        hm.put("厦门","福建");
        hm.put("珠海","广东");
        hm.put("伊犁","新疆");
        hm.put("台北","台湾");
        hm.put("福州","福建");
        hm.put("沈阳","辽宁");
        hm.put("大连","辽宁");
        hm.put("哈尔滨","黑龙江");
        hm.put("长春","吉林");

        Set<Map.Entry<String,String>> es = hm.entrySet();
        //toArray方法在底层会比较集合的长度跟数组的长度两者的大小
        //如果集合的长度〉数组的长度：数据在数组中放不下，此时会根据实际数据的个数，重新创建数组
        //如果集合的长度<=数组的长度：数据在数组中放的下，此时不会创建新的数组，而是直接用
        Map.Entry[] entryArr = es.toArray(new Map.Entry[0]);
        Map map2 = Map.ofEntries(entryArr);
        //map2.put("西安","陕西");    无法添加元素，错误信息：UnsupportedOperationException
        System.out.println(map2);

        //copyOf()方法：基于目标Map集合创建一个不可变集合，JDK10以上版本支持该方法
        //底层：
        // 如果目标Map集合本身就是不可变集合，则直接返回目标Map集合，
        // 如果目标Map集合为空，则创建一个空的不可变集合，
        // 如果目标Map集合不为空，则创建一个不可变集合，集合中包含目标Map集合的元素：(Map<K,V>)Map.ofEntries(map.entrySet().toArray(new Entry[0]))
        Map<String, String> map3 = Map.copyOf(hm);
        //map2.put("西安","陕西");  无法添加元素，错误信息：UnsupportedOperationException
        System.out.println(map3);

    }
}
