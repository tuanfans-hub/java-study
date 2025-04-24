package Lambda.methodRef;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description 构造器引用
 */
// 构造器引用
// 格式：类名::new
public class TestConstructionRef {
    @Test
    public void test(){
        //集合里面存储姓名和年龄，比如：张无忌，15
        //要求：将数据封装成Student对象并收集到List集合中
        ArrayList<String> person = new ArrayList<>();
        Collections.addAll(person, "张三,23", "李四,24", "王五,25");
        List<Person> personList = person.stream()
                .map(s -> new Person(s.split(",")[0], Integer.parseInt(s.split(",")[1])))
                .collect(Collectors.toList());
        System.out.println(personList);

        // 使用构造器引用
        //方法引用的条件：
        //1.引用处必须是函数式接口
        //2.被引用的方法必须已经存在
        //3.被引用方法的形参和返回值，需要跟抽象方法保持一致
        //4.被引用方法的功能要满足当前需求
        List<Person> personList1 = person.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(personList1);
    }

    @Test
    public void testString(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,123,456,789,234);

        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));

        Integer[] array1 = list.toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(array1));

        //引用数组的构造方法
        //方法引用的条件：
        //1.引用处必须是函数式接口
        //2.被引用的方法必须已经存在
        //3.被引用方法的形参和返回值，需要跟抽象方法保持一致
        //4.被引用方法的功能要满足当前需求
        Integer[] listArr = list.toArray(Integer[]::new);
        System.out.println(Arrays.toString(listArr));
    }
}
