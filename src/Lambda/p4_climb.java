package Lambda;

import java.util.Scanner;

/**
 * 爬楼梯，可以一次爬一个台阶或两个台阶。
 * 如果这个楼梯有20个台阶，一共有多少种爬法呢?
 * */
public class p4_climb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("台阶数：");
        int n = sc.nextInt();

        System.out.println("---------一次爬一个台阶或两个台阶---------");
        System.out.println("总计爬法:"+climb(n));

        System.out.println("------一次爬一个台阶或两个台阶或三个台阶------");
        System.out.println("总计爬法:"+climb2(n));
    }

    //爬楼梯，可以一次爬一个台阶或两个台阶。
    public static int climb(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            return climb(n-1)+climb(n-2);
            //当爬到第（n-2）个台阶时，有两种选择，分别是：爬一个台阶到达第（n-1）个台阶、爬两个台阶直接到达第n个台阶
            //但是从（n-2）个台阶爬一个台阶到达第(n-1)个台阶的情况已经包含在climb(n-1)中
            //所以只需要加上从（n-2）个台阶爬两个台阶直接到达第n个台阶的一种情况即可
        }
    }

    //爬楼梯，可以一次爬一个台阶或两个台阶或三个台阶
    public static int climb2(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 4;
        }else{
            return climb(n-1)+climb(n-2)+climb(n-4);
        }
    }

}
