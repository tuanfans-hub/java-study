package ArraysClass;

import java.util.Arrays;
import java.util.Comparator;

//Arrays类：数组的工具类，提供了很多对处理数组的方法
public class Arrays_class {
    public static void main(String[] args){
        int[] array = {2,6,5,4,4,8,3,2,1,7,8,9,5};

        System.out.println("---------------toString()---------------");
        //toString():把数组元素拼接为一个字符串并返回
        System.out.println(Arrays.toString(array));

        System.out.println("---------------sort()----------------");
        Arrays.sort(array); //先排序,默认升序
        System.out.println(Arrays.toString(array));

        System.out.println("-----------binarySearch()-------------");
        //binarySearch():二分查找指定元素，并返回元素所在的索引---注意：二分查找要求数组元素有序(升序)
        System.out.println(Arrays.binarySearch(array,3));
        System.out.println(Arrays.binarySearch(array,10));  //如果元素不存在，返回（-插入点-1）,-1的意义：如果插入元素所在位置是0索引，就会返回-1，而不会返回0，产生歧义。

        //copy方法：通过System.arraycopy()方法实现
        System.out.println("---------------copyOf()---------------");
        //copyOf():复制数组，返回一个新数组
        int[] array2 = Arrays.copyOf(array,10);
        System.out.println(Arrays.toString(array2));

        System.out.println("--------------copyOfRange-------------");
        //copyOfRange():拷贝数组，指定范围，返回一个新数组（包头不包尾）
        int[] array3 = Arrays.copyOfRange(array,2,7);
        System.out.println(Arrays.toString(array3));

        System.out.println("---------------fill()----------------");
        //fill():填充数组
        Arrays.fill(array,10);  //将数组元素全部填充为10
        System.out.println(Arrays.toString(array));

        System.out.println("--------------sort(数组,排序规则)---------------");
        /**
         * public static void sort（数组，排序规则）按照指定的规则排序
         * 参数一：要排序的数组
         * 参数二：排序的规则
         * 细节：
         * 只能给引用数据类型的数组进行排序
         * 如果数组是基本数据类型的，需要变成其对于的包装类
         *
         * 第二个参数是一个接口，所以我们在调用方法的时候，需要传递这个接口的实现类对象，作为排序的规则。
         * 但是这个实现类，我只要使用一次，所以就没有必要单独的去写一个类，直接采取匿名内部类的方式就可以了
         *
         * 底层原理：
         * 利用插入排序+二分查找的方式进行排序的。
         * 默认把0索引的数据当做是有序的序列，1索引到最后认为是无序的序列。
         * 遍历无序的序列得到里面的每一个元素，假设当前遍历得到的元素是A元素
         * 把A往有序序列中进行插入，在插入的时候，是利用二分查找确定A元素的插入点。
         * 拿着A元素，跟插入点的元素进行比较，比较的规则就是compare方法的方法体
         * 如果方法的返回值是负数，拿着A继续跟前面的数据进行比较
         * 如果方法的返回值是正数，拿着A继续跟后面的数据进行比较
         * 如果方法的返回值是0，也拿着A跟后面的数据进行比较
         * 直到能确定A的最终位置为止。
         *
         * compare方法的形式参数：
         * 参数一o1：表示在无序序列中，遍历得到的每一个元素
         * 参数二o2：有序序列中的元素
         *
         * 返回值：
         * 负数：表示当前要插入的元素是小的，放在前面
         * 正数：表示当前要插入的元素是大的，放在后面
         * 0：表示当前要插入的元素跟现在的元素比是一样的们也会放在后面
         *
         * 结论：
         * o1-o2：升序排列
         * o2-o1：降序排列
         * */
        Integer[] array4 = {2,3,6,4,9,8,7,1,5,10};
        Arrays.sort(array4, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1-o2;//升序
                return o2-o1;//降序
            }
        });
        System.out.println(Arrays.toString(array4));

    }
}
