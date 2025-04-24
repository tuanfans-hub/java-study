package File_IO._File;

import java.io.File;
import java.io.IOException;

/**
 * @author TuanFans
 * @date 2025/4/25
 * @description File练习4
 */
//删除一个指定的文件或文件夹，包括子文件和子文件夹
public class Practice4_File {
    public static void main(String[] args) {

        //创建测试文件
        mkFile();
        //这里对测试文件进行删除操作
        File file = new File("src\\File_IO\\_File\\aaa\\eee");
        deleteFile(file);
    }

    //创建测试文件
    private static void mkFile() {
        File eee = new File("src\\File_IO\\_File\\aaa\\eee");
        boolean mkdir_eee = eee.mkdirs();
        System.out.println("mkdir_eee:"+mkdir_eee);
        try {
            File e = new File(eee, "e.txt");
            boolean newFile_e = e.createNewFile();
        } catch (IOException e) {
            System.err.println("创建e.txt文件失败！");
        }
        File fff = new File(eee, "fff");
        boolean mkdir_fff = fff.mkdirs();
        System.out.println("mkdir_fff:"+mkdir_fff);
        File f = new File(fff, "f.txt");
        try {
            boolean newFile_f = f.createNewFile();
        } catch (IOException e) {
            System.err.println("创建f.txt文件失败！");
        }
    }

    //删除一个指定的文件或文件夹，包括子文件和子文件夹
    public static void deleteFile(File deleteFile){
        if(deleteFile.isFile()){
            boolean delete = deleteFile.delete();
            readDelete(deleteFile, delete);
        }else{
            File[] files = deleteFile.listFiles();
            if(files==null){
                boolean delete = deleteFile.delete();
                readDelete(deleteFile, delete);
            }else{
                //删除子文件和子文件夹
                for (File file : files) {
                    deleteFile(file);
                }
                //删除子文件和子文件夹之后，当前文件夹为空，还需对该文件进行删除操作
                //如果未进行该操作，开始为非空的文件夹将不会被删除
                boolean delete = deleteFile.delete();
                readDelete(deleteFile, delete);
            }
        }

    }

    //对文件进行删除操作后，输出删除结果
    private static void readDelete(File file, boolean delete) {
        if(delete){
            System.out.println("删除文件："+ file.getName()+"成功！");
        }else{
            System.out.println("删除文件："+ file.getName()+"失败！");
        }
    }
}
