package set_java.MyMap.MyHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Map集合案例-统计投票人数
 * 需求:
 * 某个班级80名学生，现在需要组成秋游活动，班长提供了四个景点依次是（A、B、C、D）,每个学生只
 * 能选择一个景点，请统计出最终哪个景点想去的人数最多。
 * */
public class counterStu {
    public static void main(String[] args){
        Random rand = new Random();

        int[] attractions = new int[4];
        for(int i = 0;i<80;i++){
            int index = rand.nextInt(4);
            attractions[index]++;
        }
        HashMap<Character ,Integer> counter = new HashMap<>();
        counter.put('A',attractions[0]);
        counter.put('B',attractions[1]);
        counter.put('C',attractions[2]);
        counter.put('D',attractions[3]);

        counter.forEach((a,c)-> System.out.println(c+"人选择景点"+a));

        printResult(counter);

    }

    private static void printResult(HashMap<Character, Integer> counter) {
        int max = 0;
        char attraction = ' ';
        Set<Map.Entry<Character,Integer>> entries = counter.entrySet();
        for(Map.Entry<Character,Integer> e : entries){
            if(e.getValue()>max){
                max = e.getValue();
                attraction = e.getKey();
            }
        }
        System.out.println("选择景点"+attraction+"的人数最多，有"+max+"人选择");
    }
}
