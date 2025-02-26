package set_java.set_practice;

import java.util.ArrayList;
import java.util.Collections;

public class AddStudents {
    Student s1 = new Student("萧炎",'男',200);
    Student s2 = new Student("萧熏儿",'女',198);
    Student s3 = new Student("彩粼",'女',250);
    Student s4 = new Student("林动",'男',198);
    Student s5 = new Student("凌清竹",'女',201);
    Student s6 = new Student("应欢欢",'女',196);
    Student s7 = new Student("牧尘",'男',19);
    Student s8 = new Student("洛璃",'女',20);
    Student s9 = new Student("周元",'男',1200);
    Student s10 = new Student("夭夭",'女',1500);

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Student> men = new ArrayList<>();
    ArrayList<Student> women = new ArrayList<>();

    //添加学生对象到集合中
    public void addStudents(ArrayList<Student> students){
        Collections.addAll(students,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
    }

    //实现按照性别分组
    public void groupBySex(){

        students.forEach(s->{
            if(s.getGender()=='男'){
                men.add(s);
            }else{
                women.add(s);
            }
        });

        //实现打印学生姓名
        ArrayList<String> s_names = new ArrayList<>();
        ArrayList<String> m_names = new ArrayList<>();
        ArrayList<String> w_names = new ArrayList<>();
        getName(students,s_names);
        getName(men,m_names);
        getName(women,w_names);
        System.out.println("students:\t"+s_names);
        System.out.println("men:\t\t"+m_names);
        System.out.println("women:\t\t"+w_names);
    }

    //获取学生姓名的方法
    public void getName(ArrayList<Student> students,ArrayList<String> names){
        students.forEach(s->names.add(s.getName()));
    }
}
