package set_java.Varargs;

import java.util.Scanner;

//可变参数：底层是一个数组
//可变参数只能写在最后（由此可推出）：
//  1.在方法的形参中，只能写一个可变参数
//  2.如果方法的形参中出了可变参数外还有参数，应把可变参数写在最后
public class varargs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("输入参数个数：");
        int count = sc.nextInt();
        System.out.println("---------------------");
        int[] arr = new int[count];
        for(int i = 0;i<count;i++){
            System.out.print("输入第"+(i+1)+"个参数：");
            arr[i]=sc.nextInt();
        }
        System.out.println(add(arr));
    }

    //计算n个数的和
    public static int add(int... numbers){
        int sum = 0;
        for(int n: numbers){
            sum+=n;
        }
        return sum;
    }
}
