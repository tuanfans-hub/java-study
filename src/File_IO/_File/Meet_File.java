package File_IO._File;

import javax.annotation.processing.Filer;
import java.awt.*;
import java.io.File;

/**
 * @author TuanFans
 * @date 2025/4/23
 * @description File类
 */
public class Meet_File {
    public static void main(String[] args){
        //public File(String pathname)根据文件路径创建文件对象
        String path = "C:\\Users\\shift\\Desktop\\java_io.txt";
        File file = new File(path);
        System.out.println(file);
        //public File(String parent,String child)根据父路径名字符串和子路径名字符串创建文件对象
        String parent = "C:\\Users\\shift\\Desktop";// 父路径
        String child = "java_io.txt";// 子路径
        File file1 = new File(parent, child);
        System.out.println(file1);
        //public File(File parent, String child)根据父路径对应文件对象和子路径名字符串创建文件对象
        File parentFile = new File("C:\\Users\\shift\\Desktop");
        String child2 = "java_io.txt";
        File file2 = new File(parentFile, child2);
        System.out.println(file2);
    }
}
