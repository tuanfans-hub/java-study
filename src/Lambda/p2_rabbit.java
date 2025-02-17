package Lambda;

import java.util.Scanner;

/**
 * 练习2：
 * 有一个很有名的数学逻辑题叫做不死神兔问题，有一对兔子，从出生后第三个月起每个月都生一对兔子
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问第十二个月的兔子对数为多少？
 * */
public class p2_rabbit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("输入兔子繁殖时长（月）：");
        int month = sc.nextInt();
        System.out.println("第 "+month+" 个月有 "+rabbit(month)+" 对兔子");
    }

    public static int rabbit(int month){
        if(month==1||month==2){
            return 1;
        }else{
            return rabbit(month-1)+rabbit(month-2);
        }
    }
}
