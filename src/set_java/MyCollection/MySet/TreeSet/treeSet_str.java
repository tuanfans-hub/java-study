package set_java.MyCollection.MySet.TreeSet;


import java.util.TreeSet;
/**
 * 需求：请自行选择比较器排序和自然排序两种方式；
 * 要求：存入四个字符串，"c”“ab"， "df" ， "qwer"
 * 按照长度排序，如果一样长则按照首字母排序
 * */
public class treeSet_str {
    public static void main(String[] args) {
        //方式二：比较器排序：创建TreeSet对象时候，传递比较器Comparator指定规则

        //创建集合对象
//        TreeSet<String> ts = new TreeSet<>(new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                //按照长度排序，如果一样长则按照首字母排序
//                return o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length();
//            }
//        });

        //lambda表达式
        TreeSet<String> ts = new TreeSet<>((o1,o2)->
                o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length());

        //添加对象
        ts.add("c");
        ts.add("ab");
        ts.add("df");
        ts.add("qwer");

        System.out.println(ts);
    }
}
