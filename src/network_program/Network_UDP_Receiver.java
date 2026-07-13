package network_program;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author TuanFans
 * @date 2026/5/12
 */
public class Network_UDP_Receiver {
    public static void main(String[] args) throws SocketException {
        String[] exits = {"/exit", "/quit", "/bye"};
        // 创建DatagramScoket对象，并指定该DatagramScoket对象操作使用的端口
        try(DatagramSocket socket= new DatagramSocket(8050)){
            while(true){
                System.out.println("等待接收数据...");
                // 创建数据报，用于接收数据
                byte[] buffer = new byte[1024];
                // 创建DatagramPacket对象，用于封装接收到的数据
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // 接收数据
                socket.receive(packet);
                // 获取数据
                String message = new String(packet.getData(),0,packet.getLength());
                if(exits[0].equals(message)||exits[1].equals(message)||exits[2].equals(message)) {
                    System.out.println("接收端关闭中...");
                    break;
                }
                System.out.println("接收到的数据："+message);
                System.out.println("数据来源："+packet.getAddress()+":"+packet.getPort());
                System.out.println("-----------------------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            System.out.println("UDP接收数据结束！");
        }

    }
}
