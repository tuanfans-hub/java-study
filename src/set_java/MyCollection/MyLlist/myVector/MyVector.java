package set_java.MyCollection.MyLlist.myVector;

import java.util.Vector;

/**
 * @author TuanFans
 * 1.Vector底层也是一个对象数组，protected Object[] elementData；
 * 2.Vector是线程同步的，即线程安全，Vector类的操作方法带有synchronized
 * 3.在开发中，需要线程同步安全时，考虑使用Vector
 * 4.Vector的扩容机制：
 *      如果是无参构造：默认初始化容量为10，每次扩容为原来的2倍
 *      如果是有参构造：初始化容量为参数，每次扩容为原来的2倍
 * */
@SuppressWarnings("all")
public class MyVector {
    public static void main(String[] args){
        Vector v = new Vector(8);
        for(int i = 0;i<30;i++){
            v.add(i);
        }
    }
}












