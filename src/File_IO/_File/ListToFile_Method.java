package File_IO._File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * @author TuanFans
 * @date 2025/4/24
 * @description 获取遍历文件夹
 */
public class ListToFile_Method {
    public static void main(String[] args){
        //public static File[] listRoots()列出可用的文件系统根（系统中的所有盘符）
        System.out.println("-------------------------------");
        File[] roots = File.listRoots();
        if(roots!=null){
            for (File root : roots) {
                System.out.println(root);
            }
        }
        //public String[] list()获取当前该路径下所有内容的名称
        //public File[］ listFiles()获取当前该路径下所有内容的文件对象
        System.out.println("-------------------------------");
        File java_io_file = new File("C:\\Users\\shift\\Desktop\\java_IO\\java_io_file");
        String[] fileList = java_io_file.list();
        File[] files = java_io_file.listFiles();
        if(fileList!=null){
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
        }
        System.out.println("-------------------------------");
        if(files!=null){
            for (File file : files) {
                System.out.println(file);
            }
        }

        //public String[] list(FilenameFilter filter)利用文件名过滤器获取当前该路径下所有内容
        System.out.println("-------------------------------");
        String[] filteredList = java_io_file.list(new FilenameFilter() {
            //accept(File dir, String name)返回true表示接受该文件，返回false表示不接受该文件
            //参数dir表示当前遍历的文件夹，name表示当前遍历的文件名
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile()&&name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(filteredList));
        String[] filteredList2 = java_io_file.list(
                (dir, name) -> new File(dir, name).isFile() && name.endsWith(".txt"));
        System.out.println(Arrays.toString(filteredList2));

        //public File[] listFiles(FileFilter filter)利用文件名过滤器获取当前该路径下所有内容
        System.out.println("-------------------------------");
        File[] filteredFiles = java_io_file.listFiles(new FileFilter() {
            //accept(File pathname)返回true表示接受该文件，返回false表示不接受该文件
            //参数pathname表示当前遍历的文件
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile()&&pathname.getName().endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(filteredFiles));
        File[] filteredFiles2 = java_io_file.listFiles(
                file -> file.isFile() && file.getName().endsWith(".txt"));
        System.out.println(Arrays.toString(filteredFiles2));

        //public File[] listFiles(FilenameFilter filter)利用文件名过滤器获取当前该路径下所有内容
        System.out.println("-------------------------------");
        File[] filteredFiles3 = java_io_file.listFiles(new FilenameFilter() {
            //accept(File dir, String name)返回true表示接受该文件，返回false表示不接受该文件
            //参数dir表示当前遍历的文件夹，name表示当前遍历的文件名
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".txt");
            }
        });
        System.out.println(Arrays.toString(filteredFiles3));
        File[] filteredFiles4 = java_io_file.listFiles(
                (dir, name) -> new File(dir, name).isFile() && name.endsWith(".txt"));
        System.out.println(Arrays.toString(filteredFiles4));
    }
}
