package IO_Stream.TestIO;

import java.io.*;
import java.util.Scanner;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description
 */
public class TestSystem_inToFile {
    public static void main(String[] args) {
        //目标文件
        File wFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\in_to_file.txt");

        //将键盘输入的内容写入文件中
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(wFile));
            BufferedWriter bw = new BufferedWriter(osw)){
            // 字节流 --> 转换流 --> 缓冲流
            char[] chars = new char[1024];
            String read = br.readLine();
            // 循环读取：键盘最后一行输入为“:exit”时，表示退出
            while(!read.equals(":exit")){
                bw.write(read);
                bw.newLine();//换行
                read = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
