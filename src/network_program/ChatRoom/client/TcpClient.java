package network_program.ChatRoom.client;

import network_program.ChatRoom.entity.Message;
import network_program.ChatRoom.entity.User;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author TuanFans
 * @date 2026/6/3
 */
public class TcpClient {
    private static TcpClient instance;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8085;
    private static String userName;
    private static Socket socket;
    private static OutputStream os;
    private ObjectOutputStream oos;
    private static InputStream is;
    private ObjectInputStream ois;
    private static final int HEART_BEAT_TIME = 5;
    private static final String HEART_BEAT_CONTENT = "PING";
    private volatile static boolean isRunning = true;

    static {
        try {
            socket = new Socket(HOST,PORT);
        } catch (IOException e) {
            System.out.println("客户端连接异常...");
            e.printStackTrace();
        }
    }

    private TcpClient(String name) {
        userName = name;
        try{
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
        } catch (IOException e) {
            System.out.println("客户端异常...");
            e.printStackTrace();
        }
        heartBeat();
        startReceiverThread();
    }

    private void startReceiverThread(){
        Thread receiveThread = new Thread(()->{
            System.out.println(userName+"开始接收服务器消息...");
            while(isRunning && !socket.isClosed()){
                try{
                    Message message = (Message)ois.readObject();
                    handleMessage(message);
                }  catch (EOFException|SocketException|StreamCorruptedException e) {
                    System.out.println("连接已断开...");
                    break;
                }catch (IOException | ClassNotFoundException e) {
                    if(isRunning){
                        System.out.println("接收信息异常...");
                    }
                    e.printStackTrace();
                    break;
                }
            }
        });
        receiveThread.setDaemon(true);
        receiveThread.setName("Client-Receive-Thread-"+userName);
        receiveThread.start();
    }

    private void handleMessage(Message message){
        if(message.getContent().equals(HEART_BEAT_CONTENT)) return;
        System.out.println("-------------------当前用户："+userName+"，接收到信息-------------------");
        boolean broadcast = message.isBroadcast();
        if( broadcast){
            System.out.println("【群发信息】来自："+message.getSender().getName()+"信息内容为："+message.getContent());
        }else{
            System.out.println("【私聊信息】来自："+message.getSender().getName()+"信息内容为："+message.getContent());
        }
        System.out.println("-----------当前用户："+userName+"------------");
        System.out.println("请选择操作：1-群发，2-私聊");
    }

    // 心跳机制
    private void heartBeat() {
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
        schedule.scheduleAtFixedRate(()->{
            try{
                Message ping = Message.privateMessage(new User(userName, null), new User(userName, null), HEART_BEAT_CONTENT);
                synchronized (oos) {
                    oos.writeObject(ping);
                    oos.flush();
                }
            } catch (Exception e) {
                if(isRunning){
                    System.out.println("心跳发送失败...");
                    shutdown();
                }
                schedule.shutdown();
            }
        }, 0, HEART_BEAT_TIME, TimeUnit.SECONDS);
    }

    public static TcpClient getInstance(String userName){
        if(instance==null){
            instance = new TcpClient(userName);
        }
        return instance;
    }
    public static String getUserName(){
        return userName;
    }
    public static void setUserName(String userName){
        TcpClient.userName = userName;
    }
    public static Socket getSocket(){
        return socket;
    }
    public void sendToUser(User receiver,String content) throws IOException {
        InetSocketAddress address = new InetSocketAddress(HOST, PORT);
        User sender = new User(userName, address);
        Message message = Message.privateMessage(sender, receiver, content);
        synchronized(oos){
            oos.writeObject(message);
            oos.flush();
        }
    }
    public void broadcast(String content) throws IOException {
        InetSocketAddress address = new InetSocketAddress(HOST, PORT);
        User sender = new User(userName, address);
        Message message = Message.broadcast(sender, content);
        synchronized(oos){
            oos.writeObject(message);
            oos.flush();
        }
    }

    public void shutdown(){
        isRunning = false;
        try{
            if(oos!=null) oos.close();
            if(ois!=null) ois.close();
            if(socket!=null) socket.close();
            System.out.println("客户端已关闭...");
        } catch (IOException e) {
            System.out.println("连接已断开...");
        }
    }
}
