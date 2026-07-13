package File_IO._IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/26
 * @description 多字节文件拷贝
 */
public class MoreByteFileCopy {
    public static void main(String[] args){
        FileInputStream is = null;
        FileOutputStream os = null;
        try{
            //1.创建输入流对象：读取要拷贝的文件
            is = new FileInputStream("C:\\Users\\shift\\Desktop\\java_IO\\万相之王.txt");
            //2.创建输出流对象：写入拷贝后的文件
            os = new FileOutputStream("src\\File_IO\\_IO\\file\\万相之王.txt");
            //3.2 优化：一次读取一个字节数组，一次写入一个字节数组（多读多写）
            byte[] bytes = new byte[1024*1024*5];//一次读取5M，一次写入5M
            int read;
            while((read = is.read(bytes))!=-1){
                os.write(bytes,0,read);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //4.释放资源：资源的创建与释放：尽量符合后进先出原则
            if(os!=null){
                try{
                    os.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            if(is!=null){
                try{
                    is.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
