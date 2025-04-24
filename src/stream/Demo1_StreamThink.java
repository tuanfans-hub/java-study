package stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream流的作用：
 * 结合了Lambda表达式，简化集合、数组的操作
 * <p>
 * Stream流的使用步骤：<p>
 * 1.先得到一条Stream流（流水线），并把数据放上去<p>
 *      单列集合 --- default Stream<E> Stream() --- Collection中的默认方法<p>
 *      双列集合 --- 无 --- 无法直接使用stream流<p>
 *      数组 --- public static <T> Stream<T> stream(T[] array) --- Arrays工具类中的静态方法<p>
 *      一堆零散数据 --- public static<T> Stream<T> of(T... values) --- Stream接口中的静态方法<p>
 * 2.利用Stream流中的API进行各种操作<p>
 * 过滤、转换-->中间方法：方法调用完毕之后，还可以调用其他方法<p>
 * 统计、打印-->终结方法：最后一步，调用完毕之后，不能调用其他方法<p>
 * */
public class Demo1_StreamThink {
    public static void main(String[] args) {
        System.out.println("------------单列集合-----------");
        //单列集合
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6);
        //1.得到一条Stream流，并把数据放上去
        list.stream().forEach(number-> System.out.print(number+" "));
        System.out.println();

        System.out.println("------------双列集合-----------");
        //双列集合:必须先转成单列集合才能使用stream流
        HashMap<String,String> map = new HashMap<>();
        map.put("赣州","南昌");
        map.put("九江","南昌");
        map.put("长春","辽宁");
        map.put("厦门","福建");
        map.put("珠海","广东");
//        Set<Map.Entry<String,String>> es = map.entrySet();
//        es.stream().forEach(e -> System.out.println(e));
        //第一种：获取key的单列集合
        map.keySet().stream().forEach(key -> System.out.println(key+"="+map.get(key)));
        System.out.println("--------------");
        //第二种：获取entry的单列集合
        map.entrySet().stream().forEach(e -> System.out.println(e));

        System.out.println("------------数组-----------");
        int[] array = {1,2,3,4,5,6};
        Arrays.stream(array).forEach(number -> System.out.print(number+" "));
        System.out.println();

        System.out.println("------------一堆零散数据-----------");
        //Stream接口中静态方法of的细节
        //方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组
        //但是数组必须是引用数据类型的，如果传递基本数据类型数组，会把整个数组当做一个元素，放到stream当中。
        Stream.of("甲","乙","丙","丁","戊","己","庚","辛","壬","癸").forEach(
                s -> System.out.print(s+" "));
        System.out.println();
    }
}
