package network_program.ChatRoom.entity;

import java.io.Serial;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * @author TuanFans
 * @date 2026/6/3
 */
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private InetSocketAddress address;

    public User(String name, InetSocketAddress address) {
        this.name = name;
        this.address = address;
    }
    public User(InetSocketAddress address){
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    public void setAddress(InetSocketAddress address) {
        this.address = address;
    }

    public int getPort() {
        return address.getPort();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(address.getAddress().getHostAddress(), user.getAddress().getHostName()) && Objects.equals(address.getPort(), user.address.getPort());
    }

    @Override
    public int hashCode() {
        return Objects.hash(address.getAddress().getHostName(), address.getPort());
    }
}
