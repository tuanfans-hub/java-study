package api;

import java.util.Scanner;

/**
 * @author TuanFans
 * &#064;date 2025/3/8
 */
/*
 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
 要求：
（1）用户名长度为2或3或4
（2）密码的长度为6，要求全是数字
（3）邮箱中包含@和.并且@在.的前面
 */
public class ApiTest6 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================");
        int count = 1;
        while(count<=3){
            switch(count){
                case 1:
                    count = InputUsername(sc,count);
                    break;
                case 2:
                    count = InputPassword(sc,count);
                    break;
                case 3:
                    count = InputEmail(sc,count);
                    break;
                default:
                    break;
            }
        }
        System.out.println("注册成功！");

    }

    private static int InputEmail(Scanner sc, int count) throws Exception {
        System.out.print("邮箱：");
        String email = sc.next();
        if(!email.contains("@")||!email.contains(".")||email.indexOf("@")>email.indexOf(".")){
            //throw new Exception("邮箱格式错误!");
            System.out.println("邮箱格式错误!");
        }else{
            count++;
        }
        return count;
    }

    private static int InputPassword(Scanner sc, int count) throws Exception {
        System.out.print("密码：");
        String password = sc.next();
        if(password.length()!=6||!isDigital(password)){
            //throw new Exception("密码应为长度为6的数字");
            System.out.println("密码应为长度为6的数字!");
        }else{
            count++;
        }
        return count;
    }

    private static int InputUsername(Scanner sc, int count) throws Exception {
        System.out.print("用户名：");
        String username = sc.next();
        if(username.length()<2||username.length()>4){
            //throw new Exception("用户名长度应为2~4");
            System.out.println("用户名长度应为2~4!");
        }else{
            count++;
        }
        return count;
    }

    public static boolean isDigital(String password){
        boolean flag = true;
        for(int i =0;i<password.length();i++){
            if(password.charAt(i)<'0'||password.charAt(i)>'9'){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
