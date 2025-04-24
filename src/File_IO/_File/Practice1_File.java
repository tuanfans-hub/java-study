package File_IO._File;

import java.io.File;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/25
 * @description File练习1
 */
public class Practice1_File {
    public static void main(String[] args){
        //1.在当前模块下的aaa文件夹中创建一个a.txt文件
        File aaa = new File("src\\File_IO\\_File\\aaa");
        boolean mkdir_aaa = aaa.mkdirs();
        System.out.println("mkdir_aaa:"+mkdir_aaa);
        File a = new File(aaa,"a.txt");
        try {
            boolean newFile_a = a.createNewFile();
            System.out.println("createFile_a:"+newFile_a);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
