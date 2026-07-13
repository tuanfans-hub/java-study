package network_program;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author TuanFans
 * @date 2026/6/2
 */
public class Network_TCP_Client {
    public static void main(String[] args){
        // 1. 创建Socket对象
        try(Socket socket = new Socket("127.0.0.1",8085);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            Scanner in = new Scanner(System.in);){
            while(true){
                System.out.println("请输入要发送的信息：");
                String msg = in.nextLine();
                dos.writeUTF(msg);
                if("/exit".equals(msg)||"/quit".equals(msg)||"/bye".equals(msg)){
                    System.out.println("客户端关闭中...");
                    break;
                }
                System.out.println("------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("连接异常，断开连接...");
        }
    }
}
