package network_program.ChatRoom.server;

import network_program.ChatRoom.entity.Message;

import java.io.IOException;
import java.net.Socket;

/**
 * @author TuanFans
 * @date 2026/6/3
 */
public class ChatRoomServer {
    public static void main(String[] args){
        TcpServer tcpServer = TcpServer.getInstance();
        while(true){
            try{
                Socket socket = tcpServer.accept();
                new Thread(()->{
                    while(true){
                        Message message = tcpServer.getMessage(socket);
                        if(message == null) break;
                        tcpServer.send(message);
                    }
                }).start();
            } catch (Exception e) {
                System.out.println("服务器异常，断开连接...");
                e.printStackTrace();
            }
        }
    }
}
