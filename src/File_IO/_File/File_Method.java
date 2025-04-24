package File_IO._File;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

/**
 * @author TuanFans
 * @date 2025/4/23
 * @description File类方法
 */
public class File_Method {
    public static void main(String[] args){
        //C:\Users\shift\Desktop\java_io.txt
        File file1 = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io.txt");
        File file2 = new File("C:\\Users\\shift\\Desktop\\java_IO");
        //public boolean isDirectory()判断此路径名表示的File是否为文件夹
        System.out.println("--------------------------");
        boolean file1Directory = file1.isDirectory();
        boolean file2Directory = file2.isDirectory();
        System.out.println(file1Directory);//false
        System.out.println(file2Directory);//true
        //public boolean isFile()判断此路径名表示的File是否为文件
        System.out.println("--------------------------");
        boolean file1File = file1.isFile();
        boolean file2File = file2.isFile();
        System.out.println(file1File);//true
        System.out.println(file2File);//false
        //public boolean exists()判断此路径名表示的File是否存在
        System.out.println("--------------------------");
        System.out.println(file1.exists());//true
        System.out.println(file2.exists());//true
        //public long length()返回文件的大小 (字节大小)
        System.out.println("--------------------------");
        System.out.println(file1.length());
        System.out.println(file2.length());//无法准确获取文件夹大小
        //public String getAbsolutePath()返回文件的绝对路径
        System.out.println("--------------------------");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        //public String getPath()返回定义文件时使用的路径
        System.out.println("--------------------------");
        System.out.println(file1.getPath());
        System.out.println(file2.getPath());
        //public String getName()返回文件的名称，带后缀
        System.out.println("--------------------------");
        System.out.println(file1.getName());
        System.out.println(file2.getName());
        //public long lastModified()返回文件的最后修改时间 (时间毫秒值)
        System.out.println("--------------------------");
        System.out.println(Instant.ofEpochMilli(file1.lastModified()).atZone(ZoneId.systemDefault()));
        System.out.println(Instant.ofEpochMilli(file2.lastModified()).atZone(ZoneId.systemDefault()));
        //public boolean createNewFile()创建一个新的空的文件
        System.out.println("--------------------------");
        try {
            //定义即将创建的文件
            //如果文件夹已存在，则返回false
            //如果文件夹不存在，则创建文件夹并返回true
            //如果父级文件夹不存在，则会产生异常。
            //如果创建文件时，没有后缀名，则创建一个.file 文件
            File newFile = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file\\newFile");
            //调用createNewFile方法创建对应的文件
            boolean createFile = newFile.createNewFile();
            System.out.println(createFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //public boolean mkdir()创建单级文件夹
        //如果文件夹已存在，则返回false
        //如果文件夹不存在，则创建文件夹并返回true
        //如果父级文件夹不存在，则返回false。
        System.out.println("--------------------------");
        File newDirectory = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file\\java_io_child");
        boolean mkdir = newDirectory.mkdir();
        System.out.println(mkdir);
        //public boolean mkdirs()创建多级文件夹
        //如果文件夹已存在，则返回false
        //如果文件夹不存在，则创建文件夹并返回true
        //如果父级文件夹不存在，则创建所有不存在的文件。，并返回true
        System.out.println("--------------------------");
        File newDirectory2 = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file2\\java_io_child");
        boolean mkdirs = newDirectory2.mkdirs();
        System.out.println(mkdirs);

        //public boolean delete()删除文件、空文件夹(不会进入回收站)
        //如果文件或文件夹不存在，则返回false
        //如果文件或文件夹存在且文件夹为空，则删除文件并返回true
        //如果文件夹不为空，则返回false
        System.out.println("--------------------------");
        File newDir2 = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file2\\java_io_child2");
        boolean delete = newDir2.delete();
        System.out.println(delete);
        File newDirectory3 = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file2");
        boolean delete1 = newDirectory3.delete();
        System.out.println(delete1);
        File newDir = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file3\\newFile");
        boolean delete2 = newDir.delete();
        System.out.println(delete2);

        //public File[] listFiles()获取当前该路径下所有内容（包括隐藏文件）
        //如果调用者File表示的路径不存在，则返回null
        //如果调用者File是文件，则返回null
        //如果调用者File是空文件夹，则返回null
        //如果调用者File是非空文件夹，则返回该文件夹下的所有内容（包括隐藏文件）
        //如果调用者File是需要权限才能访问的文件夹，则返回null
        System.out.println("--------------------------");
        File java_io_file = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file");
        File[] files = java_io_file.listFiles();
        if(files!=null){
            for (File file : files) {
                System.out.println(file);
            }
        }else{
            System.out.println("该文件夹是空文件夹！");
        }

        //public boolean renameTo(File dest)将文件重命名为指定的文件
        //如果文件或文件夹不存在，则返回false
        //如果文件或文件夹存在且指定的文件和目标文件的父级文件夹相同，则重命名并返回true
        //如果文件或文件夹存在且指定的文件和目标文件的父级文件夹不相同，则移动至目标文件的父级文件夹后重命名并返回true
        //如果目标文件的父级文件夹不存在，则返回false
        System.out.println("--------------------------");
        File java_io_child2 = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file\\java_io_child2");
        boolean rename = java_io_child2.renameTo(new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file\\java_io_child3"));
        System.out.println(rename);

        File java_io_child3 = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file\\java_io_child3");
        boolean rename1 = java_io_child3.renameTo(new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file3"));
        System.out.println(rename1);

        File java_io_file3 = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file3");
        boolean rename2 = java_io_file3.renameTo(new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file4\\java_io_child"));
        System.out.println(rename2);

    }
}
