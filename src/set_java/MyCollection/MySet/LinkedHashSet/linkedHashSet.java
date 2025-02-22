package set_java.MyCollection.MySet.LinkedHashSet;

import set_java.MyCollection.MySet.HashSet.Student;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet底层原理
 * 有序、不重复、无索引。
 * 这里的有序指的是保证存储和取出的元素顺序一致
 * 原理：底层数据结构是依然哈希表，只是每个元素又额外的多了一个双链表的机制记录存储的顺序。
 * */
public class linkedHashSet {
    public static void main(String[] args){
        // 创建对象
        Student s1 = new Student("林青霞",35);
        Student s2 = new Student("林青霞",35);
        Student s3 = new Student("鞠婧祎",22);
        Student s4 = new Student("毛晓彤",18);
        Student s5 = new Student("毛晓彤",18);
        Student s6 = new Student("鞠婧祎",21);
        // 创建集合对象
        LinkedHashSet<Student> lhs = new LinkedHashSet<>();
        lhs.add(s1);
        lhs.add(s2);
        lhs.add(s3);
        lhs.add(s4);
        lhs.add(s5);
        lhs.add(s6);
        // 遍历集合
        lhs.forEach(System.out::println);
    }
}
