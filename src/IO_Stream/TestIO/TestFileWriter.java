package IO_Stream.TestIO;

import java.io.*;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description
 */
public class TestFileWriter {
    public static void main(String[] args) {
        //1.创建File对象
        //源文件
        File rfile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io.txt");
        //目标文件
        File wFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io_write.txt");
        //2.创建FileReader、FileWriter对象
        try (FileReader fileReader = new FileReader(rfile);
             FileWriter fileWriter = new FileWriter(wFile,true)) {
            //3.执行读入、写出操作
            char[] chars = new char[1024];
            int read = fileReader.read(chars);
            while(read!=-1){
                String s = new String(chars, 0, read);
                fileWriter.write(s);
                read = fileReader.read(chars);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.关闭流
    }
}
