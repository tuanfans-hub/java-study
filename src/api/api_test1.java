package api;

import java.util.ArrayList;
import java.util.Scanner;

//键盘录入一些1~100之间的整数，并添加到集合中，直到集合中的所有数据之和超过200为止
public class api_test1 {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while(sum<=200){
            System.out.println("输入一个100以内的正整数：");
            String str = sc.nextLine();
            int a = Integer.parseInt(str);
            if(a>=1&&a<=100){
                list.add(a);
                sum+=a;
            }else{
                System.out.println("输入内容错误！");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
