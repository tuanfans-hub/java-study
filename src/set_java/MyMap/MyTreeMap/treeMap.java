package set_java.MyMap.MyTreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * TreeMap；
 * TreeMap跟TreeSet底层原理一样，都是红黑树结构的。
 * 由键决定特性：不重复、无索引、可排序
 * 可排序：对键进行排序。
 * 注意：默认按照键的从小到大进行排序，也可以自己规定键的排序规则
 * <p>
 * 代码书写两种排序规则：
 * 1.实现comparable接口，指定比较规则。
 * 2.创建集合时传递comparator比较器对象，指定比较规则。
 * */
public class treeMap {
    public static void main(String[] args){
        //需求1：
        //键：整数表示id
        //值：字符串表示商品名称
        //要求：按照id的升序排列、按照id的降序排列
        sortGoods();

        //需求2:
        //键：学生对象
        //值：籍贯
        //要求：按照学生年龄的升序排列，年龄一样按照姓名的字母排列，同姓名年龄视为同一个人。

        //创建学生对象
        Student s1 = new Student("zansan",35);
        Student s2 = new Student("zansan",35);
        Student s3 = new Student("lisibu",22);
        Student s4 = new Student("wangwu",18);
        Student s5 = new Student("tinua",18);
        Student s6 = new Student("liser",21);
        Student s7 = new Student("lisyu",21);

        TreeMap<Student,String> tM_stu = new TreeMap<>();
        //添加元素
        tM_stu.put(s1,"江苏");
        tM_stu.put(s2,"北京");
        tM_stu.put(s3,"上海");
        tM_stu.put(s4,"广州");
        tM_stu.put(s5,"深圳");
        tM_stu.put(s6,"杭州");
        tM_stu.put(s7,"杭州");
        foreachStudent(tM_stu);

    }

    public static void sortGoods(){
        //创建TreeMap集合

//        TreeMap<Integer,String> tM = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;//升序
//                //return o2-o1;//降序
//            }
//        });

        System.out.println("-----------sortGoods-------------");
        TreeMap<Integer,String> tM = new TreeMap<>((o1,o2)->o1-o2);//升序
        //添加元素
        tM.put(3,"苹果");
        tM.put(1,"香蕉");
        tM.put(2,"西瓜");
        tM.put(4,"橘子");

        //遍历
        //增强for循环-键值对
        for(Map.Entry<Integer,String> e : tM.entrySet()){
            System.out.println(e.getKey()+"."+e.getValue());
        }
        System.out.println("-----------------");

        //迭代器遍历-键找值
        Iterator<Integer> it = tM.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            String value = tM.get(key);
            System.out.println(key+"."+value);
        }
        System.out.println("------------------");

        //Lambda表达式遍历
        tM.forEach((key,value)-> System.out.println(key+"."+value));

    }

    public static void foreachStudent(TreeMap<Student,String> tM_stu){
        System.out.println("-----------sortGoods-------------");
        //增强for循环-键值对
        for(Map.Entry<Student,String> e : tM_stu.entrySet()){
            System.out.println(e.getKey().getName()+",\t"+e.getKey().getAge()+",籍贯："+e.getValue());
        }
        System.out.println("---------------------------------");
        //迭代器遍历
        Iterator<Student> it = tM_stu.keySet().iterator();
        while(it.hasNext()){
            Student s = it.next();
            String value = tM_stu.get(s);
            System.out.println(s.getName()+",\t"+s.getAge()+",籍贯："+value);
        }
        System.out.println("---------------------------------");
        //Lambda表达式遍历
        tM_stu.forEach((key,value)->
                System.out.println(key.getName()+",\t"+key.getAge()+",籍贯："+value));

        System.out.println("---------------------------------");
        //匿名内部类实现
        tM_stu.forEach(new BiConsumer<Student,String> (){
            @Override
            public void accept(Student key, String value) {
                System.out.println(key.getName()+",\t"+key.getAge()+",籍贯："+value);
            }
        });
    }
}
