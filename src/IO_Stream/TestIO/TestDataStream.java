package IO_Stream.TestIO;

import java.io.*;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description
 */
public class TestDataStream {
    public static void main(String[] args) {
        File wFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\data.bin");
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(wFile));
            DataInputStream dis = new DataInputStream(new FileInputStream(wFile))){
            dos.writeUTF("张三");
            dos.writeInt(18);
            dos.writeDouble(172.5);
            dos.writeInt(300);

            String name = dis.readUTF();
            int age = dis.readInt();
            double height = dis.readDouble();
            int score = dis.readInt();
            System.out.println("姓名："+name + ",年龄：" + age + ",身高：" + height + ",分数：" + score);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
