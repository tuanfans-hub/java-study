package IO_Stream.TestIO;

import java.io.*;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description
 */
public class TestBufferToLine {
    public static void main(String[] args) {
        //1.创建File对象
        //源文件
        File rf = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io.txt");
        //目标文件
        File wf = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io_write.txt");
        //2.创建FileReader对象
        //3.创建BufferedReader对象
        //4.创建FileWriter对象
        //5.创建BufferedWriter对象
        try (FileReader fr = new FileReader(rf);
             FileWriter fw = new FileWriter(wf,true);
             BufferedReader br = new BufferedReader(fr);
             BufferedWriter bw = new BufferedWriter(fw)) {
            //6.进行读写动作
            String line = br.readLine();//读取一行数据
            while(line!=null){
                bw.write(line);
                bw.newLine();//换行
                line = br.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        //7.关闭流
    }
}
