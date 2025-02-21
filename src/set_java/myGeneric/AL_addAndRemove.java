package set_java.myGeneric;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 泛型类：
 * 使用场景：
 * 当一个类中，某个变量的数据类型不确定时，就可以定义带有泛型的类
 *
 * 格式：
 * 修饰符class 类名<类型>{
 *
 * }
 * 举例：
 * public class ArrayList <E> {
 *
 * }
 * 此处E可以理解为变量，但是不是用来记录数据的，而是记录数据的类型，可以写成：T、E、K、V等
 * */
public class AL_addAndRemove<E> implements Iterable<E>,generic_interface<E> {
    private int size = 0;
    private int capacity =0;
    private Object[] obj = new Object[capacity];

    //添加元素方法--泛型方法
    public void add(E e){
        add(e,size,capacity);
    }

    //向指定的索引添加元素
    public void add(int index,E e){
        add(e,index,size,capacity);
    }

    //向集合中依次添加多个元素
    public void addAll(E... e){
        generic_function gf = new generic_function() {
            @Override
            public <E, T> void printGf(E e, T t) {

            }

            @Override
            public <E> void addElement(AL_addAndRemove<E> g, E... es) {
                for(E e : es){
                    g.add(e);
                }
            }
        };
        gf.addElement(this,e);
    }

    //删除最后一个元素
    public E remove(){
        return remove(size-1);
    }

    //删除指定索引元素，并返回该索引
    public int remove(E e) {
        for(int i:getIndex(e)){
            if(i==-1){
                System.out.println("集合中无该元素！");
                break;
            }else{
                remove(i);
                return i;
            }
        }
        return -1;
    }

    //删除集合中所有的指定元素，返回索引数组
    public int[] removeAllElement(E e){
        int endIndex = 0;
        int[] indexs = getIndex(e);
        for(int i:indexs){
            if(i==-1){
                break;
            }else{
                remove(i-endIndex);
                endIndex++;
            }
        }
        if(endIndex==0){
            return null;
        }else{
            int[] removeArr = new int[endIndex];
            System.arraycopy(indexs,0,removeArr,0,endIndex);
            return removeArr;
        }
    }

    //获取指定元素的所有索引
    private int[] getIndex(E e){
        int[] indexs = new int[size];
        Arrays.fill(indexs,-1);
        int j = 0;
        for(int i = 0;i<size;i++){
            if(obj[i].equals(e)){
                indexs[j++] = i;
            }
        }
        return indexs;
    }

    public E remove(int index){
        return remove(index, size,capacity);
    }

    public E[] removeAll(int... indexs){
        return removeAll(this,indexs);
    }



    private E remove(int index,int s,int cap){
        if(index>=size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        E str = get(index);
        removeTo(index, s, cap);
        return str;
    }

    private void removeTo(int i, int s, int cap) {
        Object[] reObj = new Object[cap];
        if(i==0){
            System.arraycopy(obj,1,reObj,0,s-1);
        }else if(i==s-1){
            System.arraycopy(obj,0,reObj,0,s-1);
        }else{
            System.arraycopy(obj,0,reObj, 0, i );
            System.arraycopy(obj, i +1,reObj, i, s - i -1);
        }
        size--;
        obj = reObj;
    }

    private void add(E e,int s,int capacity){
        check(size, capacity);
        obj[size++] = e;
    }

    //检查容量是否充足
    private void check(int s, int cap) {
        if(s >= cap){
            int tempCap = capacity;
            grow();  //如果集合容量已满，进行扩容
            obj = copy(tempCap);   //扩容之后，进行数据的拷贝
        }
    }

    //向指定索引添加元素
    private void add(E e,int index,int s,int cap){
        if(index>size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        check(size,cap);   //检查容量是否充足
        Object[] copyObj = copy(capacity);  //创建一个新数组作为拷贝的源数组
        System.arraycopy(copyObj,0,obj,0,index);
        obj[index]=e;
        size++;
        System.arraycopy(copyObj,index,obj,index+1,copyObj.length-index-1);
    }

    private void grow(){
        capacity = grow(capacity);
    }

    private int grow(int cap){
        if(cap==0){
            cap = 10;
        }else{
            cap = (cap * 3)>>>1;
        }
        return cap;
    }

    //获取集合容量
    public int getCapacity(){
        return capacity;
    }
    //获取集合大小
    public int size(){
        return size;
    }

    //根据指定索引获取元素
    public E get(int index){
        return (E)obj[index];
    }

    //实现元素拷贝
    private Object[] copy(int cap){
        Object[] newObj = new Object[capacity];
        System.arraycopy(obj,0,newObj,0,Math.min(cap,capacity));
        return newObj;
    }


    //重写迭代器方法，制定遍历规则
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            int i = 0;
            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public E next() {
                return (E)obj[i++];
            }
        };
    }

    //重写toString方法


    @Override
    public String toString() {
        Object[] printObj = new Object[size];
        System.arraycopy(obj,0,printObj,0,size);
        return Arrays.toString(printObj);
    }

    public String toString_capacity() {
        Object[] printObj = copy(size);
        return Arrays.toString(printObj);
    }

    @Override
    public <T> E[] removeAll(AL_addAndRemove<T> g, int... indexs) {
        Object[] reObj = new Object[indexs.length];
        int count = 0;
        for(int i = 0; i<indexs.length; i++){
            reObj[i] = g.remove(indexs[i]-count);
            count++;
        }
        return (E[])reObj;
    }

    @Override
    public boolean equals(Object obj) {
        // 检查是否为同一实例
        if (this == obj) {
            return true;
        }
        // 检查对象是否为同一类型
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // 转换对象并比较属性
        String s = (String) obj;
        return  this.toString().equals(s);

    }
}
