package set_java.myGeneric;

public interface generic_interface<E> {
    //指定多个索引，删除其对应的元素
    public abstract <T> E[] removeAll(generic_class<T> g,int... index);

}
