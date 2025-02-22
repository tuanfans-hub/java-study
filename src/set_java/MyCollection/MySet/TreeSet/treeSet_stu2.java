package set_java.MyCollection.MySet.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 需求：创建5个学生对象
 * 属性： (姓名，年龄，语文成绩，数学成绩，英语成绩)
 * 按照总分从高到低输出到控制台
 * 如果总分一样，按照语文成绩排
 * 如果语文一样，按照数学成绩排
 * 如果数学成绩一样，按照英语成绩排
 * 如果英文成绩一样，按照年龄排
 * 如果年龄一样，按照姓名的字母顺序排
 * 如果都一样，认为是同一个学生，不存。
 * */
public class treeSet_stu2 {
    public static void main(String[] args){
        Student2 s1 = new Student2("zhangsan",20,90,99,50);
        Student2 s2 = new Student2("lisishi",22,90,98,50);
        Student2 s3 = new Student2("wangwu",20,95,100,30);
        Student2 s4 = new Student2("sunliu",20,75,90,90);
        Student2 s5 = new Student2("sunliu",20,75,90,90);
        Student2 s6 = new Student2("anherqiao",20,95,100,30);
        Student2 s7 = new Student2("anherqi",20,95,100,30);

        TreeSet<Student2> ts = new TreeSet<>(new Comparator<Student2>(){
            @Override
            public int compare(Student2 o1, Student2 o2) {
                int result = o1.getSum()-o2.getSum();
                result = result==0?o1.getChinese()-o2.getChinese():result;
                result = result==0?o1.getMath()-o2.getMath():result;
                //result = result==0?o1.getEnglish()-o2.getEnglish():result;    可省略
                result = result==0?o1.getAge()-o2.getAge():result;
                result = result==0?o1.getName().compareTo(o2.getName()):result;

                return result;
            }
        });

        System.out.println("add(s1):"+getInfo(ts.add(s1)));
        System.out.println("add(s2):"+getInfo(ts.add(s2)));
        System.out.println("add(s3):"+getInfo(ts.add(s3)));
        System.out.println("add(s4):"+getInfo(ts.add(s4)));
        System.out.println("add(s5):"+getInfo(ts.add(s5)));
        System.out.println("add(s6):"+getInfo(ts.add(s6)));
        System.out.println("add(s7):"+getInfo(ts.add(s7)));

        ts.forEach((s)-> System.out.println(s+"，总分："+s.getSum()));


    }

    public static String getInfo(boolean flag){
        return flag?"添加成功":"添加失败";
    }
}
