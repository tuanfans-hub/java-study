package set_java.Collections;

import java.util.*;

//Collections:集合的工具类
public class collections {
    public static void main(String[] args){
        /**
         * public static <T> boolean addAll(Collection<T> c, T... elements)     批量添加元素
         * public static void shuffle(List<?> list)     打乱List集合元素的顺序
         * public static <T> void sort(List<T> list)    排序
         * public static <T> void sort(List<T> list, Comparator<T> c)       根据指定的规则进行排序
         * public static <T> int binarySearch (List<T> list,T key)      以二分查找法查找元素
         * public static <T> void copy(List<T> dest, List<T> src)       拷贝集合中的元素
         * public static <T> int fill (List<T> list，T obj)      使用指定的元素填充集合
         * public static <T> void max/min(Collection<T> coll)       根据默认的自然排序获取最大/小值
         * public static <T> void swap(List<?> list, int i, int j)      交换集合中指定位置的元素
         * */

        //public static <T> boolean addAll(Collection<T> c, T... elements)     批量添加元素
        Set<Integer> set = new TreeSet<>();
        ArrayList<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(set,5,6,3,1,4,2);
        Collections.addAll(list,"a","d","f","ca","b","ae");
        System.out.println("set:\t\t"+set);
        System.out.println("list:\t\t"+list);
        System.out.println("--------------------------");

        //public static void shuffle(List<?> list)     打乱List集合元素的顺序
        Collections.shuffle(list);
        System.out.println("list:\t\t"+list);

        System.out.println("--------------------------");

        //public static <T> void sort(List<T> list)    排序
        Collections.sort(list);
        System.out.println("list:\t\t"+list);

        System.out.println("--------------------------");

        //public static <T> void sort(List<T> list, Comparator<T> c)       根据指定的规则进行排序
//        Collections.sort(list,new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length();
//            }
//        });
        Collections.sort(list,(s1,s2)->s1.length()==s2.length()?s1.compareTo(s2):s1.length()-s2.length());
//        list.sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length());
        System.out.println("list:\t\t"+list);

        System.out.println("--------------------------");

        //public static <T> int binarySearch (List<T> list,T key)      以二分查找法查找元素
        Collections.addAll(list1,6,4,2,5,1,3);
        Collections.sort(list1);
        System.out.println("list1:\t\t"+list1);
        System.out.println(Collections.binarySearch(list1,5));
        System.out.println(Collections.binarySearch(list1,7));

        System.out.println("--------------------------");

        //public static <T> void copy(List<T> dest, List<T> src)       拷贝集合中的元素
        //要求：dest.size()>=src.size()
        //copy规则：将src中的元素值，依次拷贝到dest中，从dest的起始位置开始替换
        List<String> destList = new ArrayList<>();
        Collections.addAll(destList,"a","b","c","d","e","f","g");
        System.out.println("destList:\t"+destList);
        System.out.println("list:\t\t"+list);
        System.out.println("-----");
        Collections.copy(destList,list);
        System.out.println("destList:\t"+destList);

        System.out.println("--------------------------");

        //public static <T> int fill (List<T> list，T obj)      使用指定的元素填充集合
        Collections.fill(destList,"aa");
        System.out.println("destList:\t"+destList);

        System.out.println("--------------------------");

        //public static <T> void max/min(Collection<T> coll)       根据默认的自然排序获取最大/小值
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(set));

        System.out.println("--------------------------");

        //public static <T> void swap(List<?> list, int i, int j)      交换集合中指定位置的元素
        Collections.swap(list,0,list.size()-1);//首尾元素交换
        System.out.println("list:\t\t"+list);

    }
}
