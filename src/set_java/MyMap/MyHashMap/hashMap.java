package set_java.MyMap.MyHashMap;

import java.util.*;

/**
 * HashMap的特点:
 * HashMap是Map里面的一个实现类。
 * 没有额外需要学习的特有方法，直接使用Map里面的方法就可以了。
 * 特点都是由键决定的：无序、不重复、无索引
 * HashMap跟HashSet底层原理是一模一样的，都是哈希表结构
 * */
public class hashMap {
    /**
     * 存储学生对象并遍历
     * 需求:
     * 创建一个HashMap集合，键是学生对象(Student)，值是籍贯(String)。
     * 存储三个键值对元素，并遍历
     * 要求：同姓名，同年龄认为是同一个学生
     * */
    public static void main(String[] args){
        //创建HashMap集合对象
        HashMap<Student,String> hm = new HashMap<>();
        //创建学生对象
        Student s1= new Student("林青霞",30);
        Student s2= new Student("张曼玉",35);
        Student s3= new Student("王祖贤",33);
        Student s4= new Student("林青霞",30);
        Student s5 = new Student("鞠婧祎",18);
        Student s6 = new Student("鞠婧祎",19);
        //把学生添加到集合
        hm.put(s1,"西安");
        hm.put(s2,"武汉");
        hm.put(s3,"郑州");
        hm.put(s4,"北京");
        hm.put(s5,"上海");
        hm.put(s6,"上海");
        //遍历集合
        for (Student key : hm.keySet()) {
            String value = hm.get(key);
            System.out.println(key.getName()+","+key.getAge()+",籍贯："+value);
        }
        System.out.println("------------------");

        //键值对遍历
        Set<Map.Entry<Student,String>> e = hm.entrySet();
        Iterator<Map.Entry<Student,String>> it = e.iterator();
        while(it.hasNext()){
            Map.Entry<Student,String> entry = it.next();
            System.out.println(entry.getKey().getName()+","+entry.getKey().getAge()+",籍贯："+entry.getValue());
        }
        System.out.println("------------------");

        //Lambda表达式遍历
        hm.forEach((key,value)->
                System.out.println(key.getName()+","+key.getAge()+",籍贯："+value));
    }

}
