package stream;

import java.util.ArrayList;

/**
 * 体验Stream流的作用
 * 需求：按照下面的要求完成集合的创建和遍历
 * 创建一个集合，存储多个字符串元素
 * ArrayList<String> list = new ArrayList<>();
 * list.add（"张无忌"）；
 * list.add("周芷若");
 * list.add（"赵敏"）;
 * list.add（"张强"）；
 * list.add（"张三丰"）；
 * 1.把所有以“张”开头的元素存储到新集合中
 * 2.把“张”开头的，长度为3的元素再存储到新集合中
 * 3.遍历打印最终结果
 * */
public class FirstMeetStream {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        System.out.println("-----------没使用Stream流-------------");
        ArrayList<String> z_list1 = new ArrayList<>();
        ArrayList<String> z_list2 = new ArrayList<>();
        noStreamToList(list, z_list1, z_list2);

        System.out.println("-----------使用Stream流---------------");
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(s -> System.out.println(s));


    }

    //没使用Stream流实现
    private static void noStreamToList(ArrayList<String> list, ArrayList<String> z_list1, ArrayList<String> z_list2) {
        for(String s : list){
            if(s.startsWith("张")){
                z_list1.add(s);
                if(s.length()==3){
                    z_list2.add(s);
                }
            }
        }
        System.out.println(z_list1);
        System.out.println(z_list2);
        for(String s : z_list2){
            System.out.println(s);
        }
    }
}
