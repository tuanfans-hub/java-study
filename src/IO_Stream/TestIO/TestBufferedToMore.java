package IO_Stream.TestIO;

import java.io.*;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description
 */
public class TestBufferedToMore {
    public static void main(String[] args) {
        //1.创建File对象
        //原文件
        File rFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io.txt");
        //目标文件
        File wFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io_write.txt");
        //2.创建FileReader、FileWriter对象
        //3.创建缓冲字符流
        try(FileReader fr = new FileReader(rFile);
            FileWriter fw = new FileWriter(wFile,true);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw)){
            //4.执行读写操作
            char[] chars = new char[1024];
            int read = br.read(chars);
            while(read!=-1){
                String s = new String(chars, 0, read);
                bw.write(s);
                read = br.read(chars);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
