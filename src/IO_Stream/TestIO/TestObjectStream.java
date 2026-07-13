package IO_Stream.TestIO;

import java.io.*;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description
 */
public class TestObjectStream {
    public static void main(String[] args) {
        File file = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\data.obj");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            // 写入对象
            oos.writeObject(new Person(1, "张三", 18, "123456789"));
            // 读取对象
            Person person = (Person)ois.readObject();
            System.out.println(person);//Person{age=18, pid=1, name='张三', phone='null'}
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

class Person implements Serializable{
    @Serial
    private static final long serialVersionUID = -332663194142250272L;
    private Integer pid;
    private String name;
    private Integer age;
    private transient String phone;// transient修饰的成员变量不会被序列化

    public Person(){}

    public Person(Integer pid, String name, Integer age, String phone) {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
