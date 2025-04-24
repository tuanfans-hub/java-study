package File_IO._File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/4/25
 * @description File练习2
 */
public class Practice2_File {
    public static void main(String[] args){
        //定义一个方法找某一个文件夹中，是否有以avi结尾的电影文件.(暂时不需要考虑子文件夹)
        File file = new File("src\\File_IO\\_File\\aaa");
        List<File> files = fandFile(file);
        System.out.println(files);
    }

    public static List<File> fandFile(File file){
        //1.定义一个集合，用于存储符合要求的文件
        List<File> filteredFile = null;
        //2.获取file目录下的所有文件
        File[] files = file.listFiles();
        //3.遍历files数组，得到每一个File对象
        if (files != null) {
            for (File childFile : files) {
                //4.判断该文件是否符合筛选条件
                if(childFile.isFile()&&childFile.getName().endsWith(".avi")){
                    //5.如果是第一次筛选到符合要求的文件，就创建一个集合
                    if(filteredFile==null){
                        filteredFile = new ArrayList<>();
                    }
                    //6.添加符合筛选条件的文件到集合中
                    filteredFile.add(childFile);
                }
            }

        }
        return filteredFile;
    }
}
