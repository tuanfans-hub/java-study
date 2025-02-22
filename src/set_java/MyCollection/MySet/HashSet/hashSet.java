package set_java.MyCollection.MySet.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * HashSet底层原理:
 *   HashSet集合底层采取哈希表存储数据
 *   哈希表是一种对于增删改查数据性能都较好的结构
 * 哈希表组成:
 *   JDK8之前：数组+链表
 *   JDK8开始：数组+链表+红黑树
 * HashSetJDK8以前底层原理：
 *  1.创建一个默认长度为16，默认加载因子为0.75的数组
 *  2.根据元素的哈希值跟数组的长度计算出应存入的位置
 *  3.判断当前位置是否为null，如果是null直接存入
 *  4.如果位置不为null，表示有元素，则调用equals方法比较属性值
 *      一样：不存       不一样：存入数组，形成链表
 *      JDK8以前：新元素存入数组，老元素挂在新元素下面
 *      JDK8以后：新元素直接挂在老元素下面
 * HashSet集合特点：
 *  1.底层数据结构为哈希表
 *  2.对集合的迭代顺序不做任何保证，也就是说不保证存储和取出的元素顺序一致
 *  3.没有带索引的方法，所以不能使用普通for循环遍历
 *  4.由于是Set集合，所以是不包含重复元素的集合
 * HashSet扩容机制:
 *  1.当前容量*加载因子的值达到阈值时，就自动扩容为原来的2倍（底层数组长度为原来的2倍）
 *  2.扩容后，需要重新计算数据在哈希表中的位置，并进行搬家
 *  3.触发扩容的条件：当前集合大小 > 数组的长度 * 加载因子
 *  4.加载因子的默认值为0.75
 *  5.当链表的长度大于8且数组的长度大于64时，会将链表转换为红黑树存储数据
 *  6.当链表的长度小于6时，会将红黑树转换为链表存储数据
 * 如果集合中存储的是自定义对象，必须要重写hashcode和equals方法
 * */
public class hashSet {
    public static void main(String[] args){
        /*
        * 需求：  创建一个存储学生对象的集合，存储多个学生对象。
                使用程序实现在控制台遍历该集合。
                要求：学生对象的成员变量值相同，我们就认为是同一个对象
        * */

        //创建对象
        Student s1 = new Student("林青霞",35);
        Student s2 = new Student("林青霞",35);
        Student s3 = new Student("鞠婧祎",22);
        Student s4 = new Student("毛晓彤",18);
        Student s5 = new Student("毛晓彤",18);
        Student s6 = new Student("鞠婧祎",21);

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);

        System.out.println("-------------去重前-----------");
        //list.forEach(System.out::println);
        list.forEach(new Consumer<Student>(){

            @Override
            public void accept(Student student) {
                System.out.println(student+",+"+student.hashCode());
            }
        });

        System.out.println("-------------去重后-----------");
        //hashSet的去重原理：利用hashCode和equals方法，实现元素去重
        //当然需要对hashCode和equals方法进行重写
        for(int i = 0;i<list.size();i++){
            for(int j = i+1;j<list.size();j++){
                if(list.get(i).hashCode()!=list.get(j).hashCode()){
                    break;
                }
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }
        }

        list.forEach(student -> System.out.println(student+","+student.hashCode()));
    }
}
