package File_IO._IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/26
 * @description 自动释放资源
 */
public class AutoClose {
    public static void main(String[] args) throws FileNotFoundException {
        // try-with-resource()-jdk7
        //1.创建输入流对象：读取要拷贝的文件
        //2.创建输出流对象：写入拷贝后的文件
        try(FileInputStream fis = new FileInputStream("src\\File_IO\\_IO\\file\\input.txt");
            FileOutputStream fos = new FileOutputStream("src\\File_IO\\_IO\\file\\copy.txt")){
            //3.1.读取文件内容，写入到新文件中（一读一写）：拷贝速度慢
            int read;
            while((read = fis.read())!=-1){
                fos.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //jdk9
        FileInputStream is = new FileInputStream("src\\File_IO\\_IO\\file\\input.txt");
        FileOutputStream os = new FileOutputStream("src\\File_IO\\_IO\\file\\copy.txt");
        try(is;os){
            int read;
            while((read = is.read())!=-1){
                os.write(read);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
