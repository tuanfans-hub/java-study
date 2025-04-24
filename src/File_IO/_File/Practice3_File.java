package File_IO._File;

import java.io.File;
import java.util.*;

/**
 * @author TuanFans
 * @date 2025/4/25
 * @description File练习3
 */
public class Practice3_File {
    public static void main(String[] args){
        //在指定文件夹下，查找所有指定后缀名的文件
        File aaa = new File("src\\File_IO\\_File\\aaa");
        List<File> filteredFiles = new ArrayList<>();//存储查询到的文件的集合
        fandFile(aaa, ".txt",filteredFiles);
        filteredFiles.forEach(System.out::println);

        System.out.println("-------------------------------------------------");
        //查询桌面下的所有txt文件
        File desktop = new File("C:\\Users\\shift\\Desktop");
        List<File> txtFiles = new ArrayList<>();
        fandFile(desktop,".txt",txtFiles);
        txtFiles.forEach(System.out::println);
    }

    /**
     * 在指定文件夹中递归查找指定后缀名的文件,并将查询到的文件存储到集合中
     * @param myFile 待查询设的文件夹
     * @param suffix 待查询的指定文件后缀名
     * @param filteredFiles 存储查询到的文件的集合
     */
    public static void fandFile(File myFile,String suffix,List<File> filteredFiles ){
        try{
            File[] files = myFile.listFiles();
            if(files!=null){
                for (File file : files) {
                    if(file.isDirectory()){
                        //递归查询
                        fandFile(file,suffix,filteredFiles);
                    }else{
                        if(file.getName().endsWith(suffix)){
                            filteredFiles.add(file);
                        }
                    }
                }
            }
        }catch(SecurityException e){
            System.err.println("无法访问文件或目录！");
        }
    }
}
