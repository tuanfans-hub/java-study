package network_program.ChatRoom.server;

import network_program.ChatRoom.entity.Message;
import network_program.ChatRoom.entity.User;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author TuanFans
 * @date 2026/6/3
 */
public class TcpServer {
    private static TcpServer instance;
    private static final int PORT = 8085;
    private static ServerSocket serverSocket;
    private  static final int MAX_CONNECTIONS = 100;
    private static int currentConnections = 0;
    private static final Map<String,Socket> NAME_SOCKET_MAP = new HashMap<>();
    private static final Map<String,String> NAME_IP_MAP = new HashMap<>();
    private static final Map<Socket,ObjectInputStream> SOCKET_OIS_MAP = new HashMap<>();
    private static final Map<Socket,ObjectOutputStream> SOCKET_OOS_MAP = new HashMap<>();
    private static final Map<String,Long> NAME_LAST_ACTIVE_TIME_MAP = new HashMap<>();
    private static final int HEART_BEAT_TIME = 5;
    private static final int TIME_OUT = 3*HEART_BEAT_TIME;
    private static final String HEART_BEAT_CONTENT = "PING";

    static{
        try{
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务器启动成功，等待客户端连接...");
        }catch(Exception e){
            System.out.println("服务器异常，断开连接...");
        }
    }

    private TcpServer(){
        heartBeatCheck();
    }

    // 心跳检测
    private void heartBeatCheck(){
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
        schedule.scheduleAtFixedRate(()->{
            long now = System.currentTimeMillis();
            NAME_LAST_ACTIVE_TIME_MAP.forEach((userName,lastActiveTime)->{
                if(now-lastActiveTime>TIME_OUT*1000){
                    System.out.println("用户"+userName+"已掉线");
                    removeConnection(userName);
                }else{
                    NAME_LAST_ACTIVE_TIME_MAP.put(userName,now);
                }
            });
        },5,5, TimeUnit.MILLISECONDS);
    }

    public static TcpServer getInstance(){
        if(instance==null){
            instance = new TcpServer();
        }
        return instance;
    }

    public Socket accept() throws IOException {
        Socket socket = serverSocket.accept();
        System.out.println("用户"+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+"已连接");
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        SOCKET_OIS_MAP.put(socket,ois);
        SOCKET_OOS_MAP.put(socket,oos);
        return socket;
    }

    public Message getMessage(Socket socket) {
        Message message = null;
        try{
            ObjectInputStream ois = SOCKET_OIS_MAP.get(socket);
            message = (Message)ois.readObject();
            if(!message.getContent().equals(HEART_BEAT_CONTENT)){
                System.out.println(message.getSender().getName()+"发送信息");
                if(message.isBroadcast()){
                    System.out.println("接收者为：所有人");
                }else{
                    System.out.println("接收者为："+message.getReceiver().getName());
                }
                System.out.println("内容为："+message.getContent());
            }
            if(!NAME_SOCKET_MAP.containsValue(socket)){
                NAME_SOCKET_MAP.put(message.getSender().getName(),socket);
                NAME_IP_MAP.put(message.getSender().getName(),socket.getInetAddress().getHostName());
                NAME_LAST_ACTIVE_TIME_MAP.put(message.getSender().getName(),System.currentTimeMillis());
                currentConnections++;
            }
        }catch(EOFException e){
            System.out.println("读取消息时,发生IO异常");
            removeConnection(socket);
            e.printStackTrace();
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("服务器异常，断开连接...");
            removeConnection(socket);
            e.printStackTrace();
        }

        return message;
    }

    private void removeConnection(String userName) {
        if(NAME_SOCKET_MAP.containsKey(userName)){
            currentConnections--;
        }
        Socket socket = NAME_SOCKET_MAP.remove(userName);
        try{
            socket.close();
        } catch (IOException e) {
            System.out.println(userName+"断开连接...");
            e.printStackTrace();
        }
        NAME_IP_MAP.remove(userName);
        SOCKET_OIS_MAP.remove(socket);
        SOCKET_OOS_MAP.remove(socket);
        NAME_LAST_ACTIVE_TIME_MAP.remove(userName);
    }

    private void removeConnection(Socket socket) {
        String name;
        for (Map.Entry<String, Socket> entry : NAME_SOCKET_MAP.entrySet()) {
            if (entry.getValue().equals(socket)) {
                name = entry.getKey();
                removeConnection(name);
                break;
            }
        }
    }

    private void broadcast(Message message){
        String userName = message.getSender().getName();
        for(ObjectOutputStream oos:SOCKET_OOS_MAP.values()){
            try{
                oos.writeObject(message);
                oos.flush();
            }catch(Exception e){
                System.out.println("服务器异常，断开连接...");
                removeConnection(userName);
                e.printStackTrace();
            }
        }
    }
    private void sendToUser(Message message){
        String userName = message.getReceiver().getName();
        Socket socket = NAME_SOCKET_MAP.get(userName);
        try{
            ObjectOutputStream oos = SOCKET_OOS_MAP.get(socket);
            oos.writeObject(message);
            oos.flush();
        }catch(Exception e){
            System.out.println("服务器异常，断开连接...");
            removeConnection(userName);
            e.printStackTrace();
        }
    }

    public void send(Message message){
        try{
            if (message.isBroadcast()) {
                broadcast(message);
            }else{
                sendToUser(message);
            }
        }catch(Exception e){
            System.out.println("服务器异常，断开连接...");
            removeConnection(message.getSender().getName());
            e.printStackTrace();
        }
    }
}
