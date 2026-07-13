package IO_Stream.TestIO;

import javax.annotation.processing.Filer;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description 转换流：常用于字符编码转换
 */
public class TestStreamTrans {
    public static void main(String[] args) {
        File rFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io.txt");
        File wFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io_GBK.txt");
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(rFile), StandardCharsets.UTF_8);
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(wFile,true), "GBK");
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osw)) {
            // 字节流 --> 转换流 --> 缓冲流
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
