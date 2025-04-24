package Lambda.methodRef;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description 静态方法引用
 */
public class StaticMethodRef {
    public static void main(String[] args){
        //静态方法引用
        //格式：类名::静态方法名
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"123","456","789");
        list.stream().map(Integer::parseInt).forEach(System.out::println);
    }
}
