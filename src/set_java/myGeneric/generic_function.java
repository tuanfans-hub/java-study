package set_java.myGeneric;

/**
 * 泛型方法：
 *        1.方法中形参类型不确定时，可以使用类名后面定义的泛型<E>
 *        2.泛型方法可以定义在普通类中，也可以定义在泛型类中
 *        3.当方法被调用时，泛型方法的形参类型才会确定
 *        4.如果泛型类中定义了泛型方法，创建对象时，泛型类的泛型类型可以不确定
 *        5.泛型方法可以使用类中已经声明过的泛型，也可以使用自己声明的泛型
 * 格式举例：
 * public <E> boolean add(E e){
 *  obj[size] = e;
 *  size++;
 *  return true;
 * }
 * */
public abstract class generic_function {
    //多个泛型参数:<E,T,K,S,...>
    public abstract <E,T> void printGf(E e, T t);

    //向指定集合添加多个元素
    public abstract <E> void addElement(AL_addAndRemove<E> g, E... es);
}
