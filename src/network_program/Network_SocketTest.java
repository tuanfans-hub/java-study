package network_program;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author TuanFans
 * @date 2026/5/13
 */
public class Network_SocketTest {
    public static void main(String[] args){
        // 创建Socket套接字对象：指定服务器的IP地址和端口号；负责启动该程序内部和外部访问之间的通信
        try(Socket s = new Socket("time-a.nist.gov",13)){
            Scanner in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8);
            while(in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Socket测试结束！");
        }
    }
}
