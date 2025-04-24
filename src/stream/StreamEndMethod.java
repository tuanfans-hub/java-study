package stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * @author TuanFans
 * @date 2025/4/22
 * @description Stream流的终结方法
 */
public class StreamEndMethod {
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "熊大","熊二","张三", "李四", "王五", "赵六", "孙七","张无忌", "赵四", "王五", "赵六", "孙七");
        //1.void forEach(Consumer action)遍历
        //2.long count()统计
        System.out.println(names.stream().filter(s->s.startsWith("张")).count());
        //toArray()收集流中的数据，放到数组中
        //无参数，返回一个Object数组
        System.out.println(Arrays.toString(names.stream().filter(s -> s.startsWith("张")).toArray()));
        //有参数，返回一个指定类型的数组
        //toArray(IntFunction generator):
        //参数作用：负责创建一个指定类型的数组
        //底层实现：依次得到数据流中的元素，并将数据流中的元素放到数组中
        //匿名内部类实现
        String[] nameArr = names.stream().filter(s -> s.startsWith("张")).toArray(new IntFunction<String[]>() {
            /**
             * 根据参数value，返回一个指定长度的数组
             * @param value 数据流中的元素个数
             * @return 返回一个指定长度数组
             */
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(nameArr));
        //lambda表达式实现
        String[] nameArray = names.stream().filter(s -> s.startsWith("张")).toArray(value -> new String[value]);
        System.out.println(Arrays.toString(nameArray));

        //3.collect(Collector collector)收集流中的数据，放到集合中
        ArrayList<String> persons = new ArrayList<>();
        Collections.addAll(persons, "嘟嘟-女-5", "李麻花-男-40", "蹦蹦-女-15", "毛毛-男-16",
                "熊二-男-19","翠花-女-23","赵琳-女-18","光头强-男-28","熊大-男-20","熊大-男-20");
        //收集所有男性的信息到list集合
        List<String> menList = persons.stream().filter(s -> s.split("-")[1].equals("男"))
                .collect(Collectors.toList());
        System.out.println(menList);
        //收集所有女性信息到set集合
        Set<String> menSet = persons.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(menSet);
        //收集所有女性信息到map集合
        //Collectors.toMap(Function<String, String> keyMapper, Function<String, Integer> valueMapper):
        // 参数一：keyMapper：指定key的生成规则
        // 参数二：valueMapper：指定value的生成规则
        // Function<String, String>:
        // 泛型一：数据流中的数据类型
        // 泛型二：生成Map中对应的数据类型
        // 方法apply(T t): 生成对应的数据规则；返回值：生成的数据
        Map<String, Integer> menMap = persons.stream()
                .filter(s -> "女".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        s -> s.split("-")[0],
                        s -> Integer.parseInt(s.split("-")[2])));
        System.out.println(menMap);
    }
}
