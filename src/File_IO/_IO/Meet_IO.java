package File_IO._IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/25
 * @description 初识IO流
 */
//IO流：用于读写文件中的数据（可以读写本地文件或网络中的数据）
    //IO流按操作文件类型分为两种：
        //1.字节流：用于读写字节数据（8位），能操作所有文件
            //(1).字节输入流(InputStream)：用于从文件中读取字节数据
            //(2).字节输出流(OutputStream)：用于向文件中写入字节数据
        //2.字符流：用于读写字符数据（16位），只能操作纯文本文件
            //(1).字符输入流(Reader)：用于从文件中读取字符数据
            //(2).字符输出流(Writer)：用于向文件中写入字符数据

    //IO流按流的方向分为三种类型：
        //1.输入流：用于从文件中读取数据
        //2.输出流：用于向文件中写入数据
        //3.转换流：用于将字节流转换为字符流

    //IO流分为四种角色：
        //1.源：数据源，数据源可以是文件、网络、键盘、鼠标等
        //2.流：数据流，数据流是源和程序之间的连接
public class Meet_IO {
    public static void main(String[] args){
        //写入数据到文件中
        try {
            //1.创建字节输出流对象，构造方法中传递字节输出流
            //参数："文件路径"或者File对象;
            //如果文件中不存在，则创建文件；但是要保证父级路径是存在的。
            //如果文件存在，则清空文件
            FileOutputStream fos =
                    new FileOutputStream("C:\\Users\\shift\\Desktop\\java_IO\\java_io_new.txt");
            //2.调用字节输出流对象的方法write，把数据写入到文件中
            // write(byte b)：
            fos.write('A');
            fos.write('B');
            //write(byte[] b)：
            byte[] bytes = {'a','b','c',100,101,102};
            fos.write(bytes);
            //write(byte[] b,int off,int len)：
            //off：数组的起始索引
            //len：读取数组的长度
            fos.write(bytes,0,3);
            //3.释放资源
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
