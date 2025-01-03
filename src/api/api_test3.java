package api;

import java.util.ArrayList;

//定义一个方法实现toBinaryString方法，将一个十进制的整数转成字符串表示的二进制
public class api_test3 {
    public static void main(String[] args) {
        System.out.println(rewrite_toBinaryString1(100));
        System.out.println(rewrite_toBinaryString2(100));
        System.out.println(rewrite_toBinaryString3(100));
    }

    //方法1
    public static String rewrite_toBinaryString1(int number){
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int a = 0;
        while(!(a == 1&&number ==0)){
            a = number % 2;
            list.add(a);
            number = number / 2;
        }
        for (int i = list.size()-1; i >= 0; i--) {
            result.append(list.get(i));
        }
        return result.toString();
    }

    //方法2
    public static String rewrite_toBinaryString2(int number){
        StringBuilder result = new StringBuilder();
        int a = 0;
        while(!(a == 1&&number ==0)){
            a = number % 2;
            //result.insert(0,a);
            result.append(a);
            number = number / 2;
        }
        return result.reverse().toString();
    }

    //方法3
    public static String rewrite_toBinaryString3(int number){
        StringBuilder result = new StringBuilder();
        int a = 0;
        while(!(a == 1&&number ==0)){
            a = number % 2;
            result.insert(0,a);
            number = number / 2;
        }
        return result.toString();
    }
}
