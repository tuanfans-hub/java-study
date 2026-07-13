package File_IO._IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/26
 * @description 输出流:写入文件数据
 */

public class Output_ {
    public static void main(String[] args){
        //换行写：
        String path = "src\\File_IO\\_IO\\file\\outPut.txt";
        try {
            //1.创建字节输出流对象，构造方法中传递字节输出流
            FileOutputStream fos = new FileOutputStream(path);
            //2.调用字节输出流对象的方法write，把数据写入到文件中
            String str = "I am a student!";
            fos.write(str.getBytes());
            //3.写入换行符：
            // windows：\r\n,java底层进行了优化，只写\r或\n也能实现换行
            // linux：\n
            // mac ：\r
            fos.write("\r\n".getBytes());
            //4.写入下一行数据
            fos.write("Nice to meet you!".getBytes());
            //5.释放资源
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //续写：在构造方法中添加一个参数true
        //在原文件的最后追加内容
        try{
            //1.创建字节输出流对象，构造方法中添加一个参数true；
            // 第二个参数为续写开关,默认为false，表示清空原文件再写入。
            //如果为true，表示在原文件的最后追加内容。
            //如果为false，表示清空原文件再写入。
            FileOutputStream fos = new FileOutputStream(path, true);
            //2.调用字节输出流对象的方法write，把数据写入到文件中
            fos.write("\r\n".getBytes());//换到下一行写入
            fos.write("Welcome to java world!".getBytes());
            //3.释放资源
            fos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

