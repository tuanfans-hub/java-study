package IO_Stream.TestIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/6/28
 * @description
 */
public class TestFileReaderToMore {
    public static void main(String[] args){
        //1.创建File对象
        File file = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io.txt");
        //2.创建FileReader对象
        try (FileReader fr = new FileReader(file)) {
            //3.一次读取多个字符
            char[] chars = new char[1024];//一次读取1024个字符
            int read = fr.read(chars);
            while(read != -1){
                //读到结尾时返回-1
                System.out.println("此次读取字符个数："+read);
                System.out.println("---------------------------");
                System.out.print(new String(chars,0,read));
                read = fr.read(chars);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //4.关闭流:try-with-resources自动完成关闭流的操作
    }
}
