package set_java.set_practice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//班级里有N个学生
//要求：
//被点到的学生不会再被点到。
//但是如果班级中所有的学生都点完了，需要重新开启第二轮点名。
public class p3_rollCall {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AddStudents A = new AddStudents();
        A.addStudents(A.students);

        ArrayList<Student> calledStudents = new ArrayList<>();
        Random rand = new Random();

        ArrayList<String> s_names = new ArrayList<>();
        ArrayList<String> called_names = new ArrayList<>();
        A.getName(A.students,s_names);
        System.out.println(s_names);

        ArrayList<Student> students = new ArrayList<>();
        A.addStudents(students);
        int counter = 0;
        while(true){
            if(students.isEmpty()){
                calledStudents.clear();
                called_names.clear();
                counter++;
                System.out.println("已点完第"+counter+"轮，将重新开始点名！");
                A.addStudents(students);
            }
            System.out.print("是否随机点名？(0.否/1.是)：");
            int input = sc.nextInt();
            if(input==0){
                break;
            }else if(input!=1){
                System.out.println("无法识别服务编号！");
                continue;
            }
            int index = rand.nextInt(students.size());
            Student called = students.get(index);
            students.remove(called);
            if(calledStudents.contains(called)){
                continue;
            }
            calledStudents.add(called);
            called_names.add(called.getName());
            System.out.println("此次点到的同学是："+called.getName());
            System.out.println("已点名的同学名单："+called_names);
        }

    }
}
