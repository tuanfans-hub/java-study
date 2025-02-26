package set_java.set_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * 班级里有N个学生
 * 要求：
 * 70%的概率随机到女生
 * 30%的概率随机到男生
 * */
public class p2_rollCall{
    public static void main(String[] args) {

        AddStudents A = new AddStudents();
        ArrayList<Student> men = A.men;
        ArrayList<Student> women = A.women;

        //添加学生对象到集合中
        A.addStudents(A.students);

        //实现按照性别分组
        A.groupBySex();


        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        //实现随机点名一
        randGetStudent1(rand,sc, men, women);
        System.out.println("-------------------分割线-----------------");
        //实现随机点名二
        randGetStudent2(rand,sc,men,women);


    }

    //实现随机点名一的方法
    private static void randGetStudent1(Random rand,Scanner sc,ArrayList<Student> men, ArrayList<Student> women) {
        double getSex = rand.nextDouble(1);
        System.out.print("设置点到男生的概率(0~1)：");
        double getMan = sc.nextDouble();
        System.out.println("随机小数为："+getSex);
        if(getSex<getMan){
            Collections.shuffle(men);
            System.out.println("此次点到的同学为"+ men.getFirst().getName());
        }else{
            Collections.shuffle(women);
            System.out.println("此次点到的同学为"+ women.getFirst().getName());
        }
    }

    //实现随机点名二的方法
    private static void randGetStudent2(Random rand,Scanner sc,ArrayList<Student> men,ArrayList<Student> women){
        System.out.print("设置点到男生的概率(0~10)：");
        int len = sc.nextInt();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i<len?1:0;
        }
        int index = rand.nextInt(arr.length);
        System.out.println("随机数为："+index);
        if(arr[index]==1){
            Collections.shuffle(men);
            System.out.println("此次点到的同学为"+ men.getFirst().getName());
        }else{
            Collections.shuffle(women);
            System.out.println("此次点到的同学为"+ women.getFirst().getName());
        }
    }


}
