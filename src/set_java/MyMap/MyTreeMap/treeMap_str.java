package set_java.MyMap.MyTreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * 新的统计思想：利用map集合进行统计
 * 如果题目中没有要求对结果进行排序，默认使用HashMap
 * 如果题目中要求对结果进行排序，请使用TreeMap
 * 键：表示要统计的内容
 * 值：表示次数
 * */
public class treeMap_str {
    public static void main(String[] args){
        //统计个数
        //需求：字符串“aeababcabcdabcd"
        //请统计字符串中每一个字符出现的次数，并按照以下格式输出
        //输出结果:
        //a(5)b(4)c(3)d(2)e(1)

        String str = "aeababcabcdabcd";

        //定义一个数组
        char[] arr = str.toCharArray();

        TreeMap<Character,Integer> tm = new TreeMap<>((o1,o2)->o1-o2);
        for(char c:arr){
            if(tm.containsKey(c)){
                //获取当前字符个数
                int count = tm.get(c);
                //个数+1
                count++;
                //更新集合
                tm.put(c,count);
            }else{
                tm.put(c,1);
            }
        }

        //遍历集合，按照指定格式输出
        //增强for循环
        System.out.println("-----------------------");
        for(Map.Entry<Character,Integer> e : tm.entrySet()){
            System.out.print(e.getKey()+"("+e.getValue()+")");
        }
        System.out.println();
        //迭代器遍历
        System.out.println("-----------------------");
        Iterator<Map.Entry<Character,Integer>> it = tm.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character,Integer> e = it.next();
            System.out.print(e.getKey()+"("+e.getValue()+")");
        }
        System.out.println();
        //Lambda表达式遍历
        System.out.println("-----------------------");
        tm.forEach((key,value)-> System.out.print(key+"("+value+")"));
        System.out.println();
        //匿名内部类实现
        System.out.println("-----------------------");
        tm.forEach(new BiConsumer<Character,Integer>(){
            @Override
            public void accept(Character key, Integer value) {
                System.out.print(key+"("+value+")");
            }
        });
        System.out.println();

    }
}
