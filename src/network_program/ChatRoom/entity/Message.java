package network_program.ChatRoom.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author TuanFans
 * @date 2026/6/3
 */
public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final User sender;
    private final User receiver;
    private final String content;
    private final boolean isBroadcast;

    private Message(User sender,User receiver,String content){
        this.sender=sender;
        this.receiver=receiver;
        this.content=content;
        this.isBroadcast=false;
    }
    private Message(User sender,String content){
        this.sender=sender;
        this.receiver=null;
        this.content=content;
        this.isBroadcast=true;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public boolean isBroadcast() {
        return isBroadcast;
    }

    public static Message privateMessage(User sender,User receiver,String content){
        return new Message(sender,receiver,content);
    }

    public static Message broadcast(User sender,String content){
        return new Message(sender,content);
    }
}
