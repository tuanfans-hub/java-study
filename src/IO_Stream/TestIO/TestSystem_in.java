package IO_Stream.TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author TuanFans
 * @date 2025/6/29
 * @description
 */
public class TestSystem_in {
    public static void main(String[] args) {
        System.out.println("请输入内容：");
        //System.in：标准输入流，默认从键盘输入
        //Scanner：扫描器，可以扫描输入；不仅可以扫描键盘输入的内容，也可以扫描文件输入的内容
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(s);

        File rFile = new File("H:\\Java\\JavaCode\\Foundation_JAVA\\src\\IO_Stream\\java_IO\\java_io.txt");
        try (FileInputStream fis = new FileInputStream(rFile)) {
            sc = new Scanner(fis);
            while(sc.hasNext()){
                System.out.println(sc.nextLine());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
