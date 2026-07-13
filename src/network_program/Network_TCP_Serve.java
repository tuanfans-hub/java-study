package network_program;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TuanFans
 * @date 2026/6/2
 */
public class Network_TCP_Serve {
    public static void main(String[] args) {
        try(ServerSocket socket = new ServerSocket(8085);){
            while(true){
                Socket accepted = socket.accept();
                // 支持多个客户端连接
                new Thread(()->{
                    try(DataInputStream dis = new DataInputStream(accepted.getInputStream());){
                        System.out.println("接收到一个连接：" + accepted.getInetAddress() + ":" + accepted.getPort());
                        System.out.println("等待接收数据...");
                        while (true) {
                            String message = dis.readUTF();
                            if ("/exit".equals(message) || "/quit".equals(message) || "/bye".equals(message)) {
                                System.out.println(accepted.getInetAddress() + ":" + accepted.getPort() + "断开连接...");
                                break;
                            }
                            System.out.println(accepted.getInetAddress() + ":" + accepted.getPort() + "-->" + message);
                            System.out.println("-----------------------------------");
                        }
                    } catch (Exception e) {
                        System.out.println(accepted.getInetAddress() + ":" + accepted.getPort() + "断开连接...");
                    }
                }).start();
            }
        } catch (Exception e) {
            System.out.println("服务器异常，断开连接...");
            System.out.println("服务端关闭中...");
        }
    }
}
