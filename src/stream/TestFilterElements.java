package stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description stream流练习
 */

public class TestFilterElements {
    @Test
    public void testFilterEven(){
        //定义一个集合，并添加一些整数1，2，3，4，5，6，7，8，9，10
        //过滤奇数，只留下偶数。
        //并将结果保存起来
        Integer[] numbers= {1,2,3,4,5,6,7,8,9,10};
        List<Integer> evens = Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens);
    }

    @Test
    public void testFilterAge(){
        //创建一个ArrayList集合，并添加以下字符串，字符串中前面是姓名，后面是年龄
        //"张三, 23"
        //"李四, 24"
        //"王五, 25"
        //保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值
        ArrayList<String> person = new ArrayList<>();
        Collections.addAll(person, "张三,23", "李四,24", "王五,25");
        Map<String, String> filteredPerson = person.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(
                        s -> s.split(",")[0],
                        s -> s.split(",")[1]
                ));
        System.out.println(filteredPerson);
    }

    @Test
    public void testFilterActor(){
        //现在有两个ArrayList集合，
        //第一个集合中：存储6名男演员的名字和年龄。第二个集合中：存储6名女演员的名字和年龄。
        //姓名和年龄中间用逗号隔开。比如：张三,23
        //要求完成如下的操作：
        //1，男演员只要名字为3个字的前两人
        //2，女演员只要姓杨的，并且不要第一个
        //3，把过滤后的男演员姓名和女演员姓名合并到一起
        //4，将上一步的演员信息封装成Actor对象。
        //5，将所有的演员对象都保存到List集合中。
        //备注：演员类Actor，属性有：name，age
        ArrayList<String> actor = new ArrayList<>();// 男演员
        Collections.addAll(actor, "张三三,23", "李四,24", "王五五,25", "赵六,26", "田七七,27", "孙八,28");
        ArrayList<String> actress = new ArrayList<>();//女演员
        Collections.addAll(actress, "赵丽颖,23", "杨颖,24", "杨紫,25", "毛晓彤,20", "赵露思,22", "杨幂,28");
        List<Actor> actorList = Stream.concat(
                actor.stream()
                        .filter(s -> s.split(",")[0].length() == 3)
                        .limit(2),
                        actress.stream()
                                .filter(s -> s.startsWith("杨"))
                                .skip(1))
                .map(s -> new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1])))
                .collect(Collectors.toList());
        System.out.println(actorList);
    }

}
