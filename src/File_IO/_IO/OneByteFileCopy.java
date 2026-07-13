package File_IO._IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/26
 * @description 一字节文件拷贝
 */
public class OneByteFileCopy {
    public static void main(String[] args){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.创建输入流对象：读取要拷贝的文件
            fis = new FileInputStream("src\\File_IO\\_IO\\file\\input.txt");
            //2.创建输出流对象：写入拷贝后的文件
            fos = new FileOutputStream("src\\File_IO\\_IO\\file\\copy.txt");
            //3.1.读取文件内容，写入到新文件中（一读一写）：拷贝速度慢
            int read;
            while((read = fis.read())!=-1){
                fos.write(read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //4.释放资源：资源的创建与释放：尽量符合后进先出原则
            if (fos != null) {
                try{
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis!=null){
                try{
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
