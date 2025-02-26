package set_java.set_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//班级里有N个学生，学生属性：姓名，年龄，性别。
//实现随机点名器
public class p1_rollCall {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"李雪琪","金瓶儿","小白","火灵儿","清漪","徐欣","萧熏儿","彩粼","夭夭");
        System.out.println(list);
        //方式一：随机生成索引
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        System.out.println("此次点到的同学是："+list.get(index));
        System.out.println("------------------------------");

        //方式二
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println("此次点到的同学是："+list.getFirst());
    }
}
