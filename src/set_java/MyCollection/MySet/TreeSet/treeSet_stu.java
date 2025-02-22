package set_java.MyCollection.MySet.TreeSet;

import java.util.TreeSet;

/**
 * TreeSet的两种比较方式：
 * <p>
 * 方式一：
 * 默认排序/自然排序：Javabean类实现comparable接口指定比较规则
 * <p>
 * 方式二：
 * 比较器排序：创建TreeSet对象时候，传递比较器Comparator指定规则
 * <p>
 * 需求：创建TreeSet集合，并添加3个学生对象
 * 学生对象属性：姓名，年龄。
 * 要求按照学生的年龄进行排序
 * 同年龄按照姓名字母排列 (暂不考虑中文)
 * 同姓名，同年龄认为是同一个人
 * */
public class treeSet_stu {
    public static void main(String[] args) {
        //方式一：默认排序/自然排序：Javabean类实现comparable接口指定比较规则
        //创建对象
        Student s1 = new Student("zhangsan",35);
        Student s2 = new Student("zhangsan",35);
        Student s3 = new Student("lisi",22);
        Student s4 = new Student("wangwu",18);
        Student s5 = new Student("tianhuai",18);
        Student s6 = new Student("lisi",21);
        Student s7 = new Student("lis",21);

        //创建集合对象
        TreeSet<Student> ts = new TreeSet<>();

        //添加对象
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s7);

        //遍历集合
        for(Student s : ts){
            System.out.println(s);
        }
    }
}
