package File_IO._IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author TuanFans
 * @date 2025/4/27
 * @description 字符编码
 */
public class Encoding_File {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream("src\\File_IO\\_IO\\file\\input.txt");
        try(is){
            int read;
            while((read=is.read())!=-1){
                System.out.print((char)read);
                //控制台出现中文乱码
                //原因1：读取数据时未读完整个汉字
                //原因2：编码和解码时的方式不统一
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
