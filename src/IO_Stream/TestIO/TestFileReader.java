package IO_Stream.TestIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/6/28
 * @description
 */
public class TestFileReader {
    public static void main(String[] args){
        //1.创建File对象
        File file = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io.txt");
        //2.创建FileReader对象
        try (FileReader fr = new FileReader(file)) {
            //3.进行读取动作
            int data = fr.read();
            while(data != -1){
                //返回读取的字符的ASCII码值；读到结尾时返回-1；
                System.out.print((char)data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.关闭流:try-with-resources自动完成关闭流的操作
    }
}
