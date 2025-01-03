package numunNumber;
//回文数判断：是，返回ture；否，返回false
import java.util.Scanner;

public class numun {
    public static void main(String[] args){
        System.out.println("请输入一个整数：");
        Scanner num=new Scanner(System.in);
        int n = num.nextInt();
        int temp = n;

        int N = 0;
        while(n>0){
            int ge = n % 10;
            n/=10;
            N = 10*N+ge;
        }

        System.out.println("该整数的倒序为："+N+"；\n所以，该整数为回文数："+(temp==N));
    }
}
