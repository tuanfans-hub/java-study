package File_IO._IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/26
 * @description 输入流：读取文件
 */
public class Input_ {
    public static void main(String[] args){
        String path = "src\\File_IO\\_IO\\file\\inPut.txt";
        try{
            //1.创建字节输入流对象，构造方法中传递字节输入流
            //如果文件不存在，会报FileNotFoundException异常
            FileInputStream fis = new FileInputStream(path);
            //2.调用字节输入流对象的方法read，读取文件
            int read = fis.read();
            //每次读取一个字节，返回读取到的字符对应的ascii码值，同时移动读取指针到下一个字节
            //如果文件读取完毕，返回-1
            while(read!=-1){
                System.out.print((char)read);
                read = fis.read();
            }
            /*
            以下代码也可实现循环读取文件
            int read;
            while((read = fis.read())!=-1){
                System.out.print((char)read);
            }
             */
            //3.释放资源
            fis.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
