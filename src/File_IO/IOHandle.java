package File_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/26
 * @description IO处理：把常见的异常处理封装到IOHandle类中
 */
public class IOHandle {
    //IO流资源关闭
    public static void close(FileInputStream is, FileOutputStream os){
        if(os!=null){
            try{
                os.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        if(is!=null){
            try{
                is.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
