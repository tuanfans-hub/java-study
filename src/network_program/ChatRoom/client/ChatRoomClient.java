package network_program.ChatRoom.client;

import network_program.ChatRoom.entity.User;

import java.util.Scanner;

/**
 * @author TuanFans
 * @date 2026/6/3
 */
public class ChatRoomClient {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = in.nextLine();
        TcpClient client = TcpClient.getInstance(username);
        Runtime.getRuntime().addShutdownHook(new Thread(client::shutdown));
        while(true){
            try{
                System.out.println("-----------当前用户："+username+"------------");
                System.out.println("请选择操作：1-群发，2-私聊");
                String choice = in.nextLine();
                System.out.println("请输入要发送的内容：");
                String content = in.nextLine();
                if(choice.equals("1")){
                    client.broadcast(content);
                }else if(choice.equals("2")){
                    System.out.println("请输入接收者的用户名：");
                    String receiverName = in.nextLine();
                    User receiver = new User(receiverName,null);
                    client.sendToUser(receiver,content);
                }
            } catch (Exception e) {
                System.out.println("客户端异常，断开连接...");
                e.printStackTrace();
            }
        }
    }

}
