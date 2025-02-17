package Lambda;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一堆桃子，猴子第一天吃了其中的一半，并多吃了一个！以后每天猴子都吃当前剩下来的一半，然后
 * 再多吃一个，第10天的时候（还没吃），发现只剩下一个桃子了，请问，最初总共多少个桃子？
 * */
public class p3_peach {
    public static void main(String[] args){
        int[] peachNum = new int[10];
        for(int day = 0;day<10;day++){
            peachNum[day]=peach(day+1);
        }
        System.out.println("桃子每天剩余个数"+ Arrays.toString(peachNum));

    }

    public static int peach(int day){
        if(day == 10){
            return 1;
        }else{
            return (peach(day+1)+1)*2;
        }
    }
}
