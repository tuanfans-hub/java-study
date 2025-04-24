package File_IO._File;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author TuanFans
 * @date 2025/4/25
 * @description File练习5
 */
//需求：统计一个文件夹中每种文件的个数并打印。(考虑子文件夹)
//打印格式如下：
//txt:3个
//doc:4个
//jpg:6个
public class Practice5_File {
    public static void main(String[] args) {
        File file = new File("src\\File_IO\\_File\\aaa");
        Map<String,Integer> fileCountMap = new HashMap<>();
        printFileCount(file,fileCountMap);
        fileCountMap.forEach((key,value)->System.out.println(key+":"+value+"个"));
    }

    public static void printFileCount(File file, Map<String,Integer> fileCountMap){
        File[] files = file.listFiles();
        if(files!=null){
            for (File f : files) {
                if(f.isFile()){
                    //获取文件后缀名
                    String[] split = f.getName().split("\\.");
                    //如果文件没有后缀名，则默认为file
                    //以最后一个.为分隔符，获取后缀名
                    String suffix = split.length==1?"file":split[split.length-1];
                    //if(fileCountMap.containsKey(suffix)){
                    //    fileCountMap.put(suffix,fileCountMap.get(suffix)+1);
                    //}else{
                    //    fileCountMap.put(suffix,1);
                    //}
                    //Map.merge(key,value,function)方法
                    //Lambda表达式实现
                    fileCountMap.merge(suffix, 1, Integer::sum);
                    //匿名内部类实现
                    //fileCountMap.merge(suffix, 1, new BiFunction<Integer, Integer, Integer>() {
                    //    @Override
                    //    public Integer apply(Integer oldValue, Integer newValue) {
                    //        return oldValue+newValue;
                    //    }
                    //});
                }else{
                    //递归遍历子文件夹
                    printFileCount(f,fileCountMap);
                }
            }
        }
    }
}

