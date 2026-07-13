package network_program;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author TuanFans
 * @date 2026/5/12
 */
public class Network_UDP_Sender {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] exits = {"/exit", "/quit", "/bye"};
        // 创建DatagramScoket对象，并指定该DatagramScoket对象操作使用的端口；如果不指定端口，系统会随机分配一个空闲端口
        try(DatagramSocket socket = new DatagramSocket()){
            while(true){
                System.out.println("输入要发送的数据信息：");
                // 创建数据
                String message = sc.next();
                // 创建数据报
                byte[] buffer = message.getBytes();
                // 创建发送地址
                InetAddress address = InetAddress.getByName("127.0.0.1");
                // 创建数据包：发送数据，数据报的数据，数据报的数据长度，目标主机的IP地址，目的主机的端口号
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8050);
                // 发送数据包
                socket.send(packet);
                System.out.println("数据已发送："+message);
                if(exits[0].equals(message)||exits[1].equals(message)||exits[2].equals(message)) {
                    System.out.println("发送端关闭中...");
                    break;
                }
                System.out.println("-------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("UDP数据发送结束！");
        }
    }
}
