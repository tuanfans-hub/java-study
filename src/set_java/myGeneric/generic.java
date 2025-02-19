package set_java.myGeneric;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * 泛型的格式：：<数据类型>
 * 注意：泛型只能支持引用数据类型
 *
 *
 * 如果我们没有给集合指定类型，默认认为所有的数据类型都是object类型
 * 此时可以往集合添加任意的数据类型。
 * 坏处：我们在获取数据的时候，无法使用它的特有行为。
 * */
public class generic {
    public static void main(String[] args){
        generic_class<String> gc = new generic_class<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------泛型类测试-------------------");
        System.out.println("集合中元素个数："+gc.size());
        System.out.println("集合容量："+gc.getCapacity());
        //添加元素
        System.out.print("待添加元素个数：");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            gc.add("java");
        }

        System.out.println("普通for循环：");
        for(int i = 0; i<gc.size()-1; i++){
            System.out.print(gc.get(i)+",");
        }
        System.out.println(gc.get(gc.size()-1));

        System.out.println("增强for循环：");
        for(String s:gc){
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("forEach匿名内部类遍历：");
        gc.forEach(new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
        System.out.println();

        System.out.println("forEach遍历(Lambda表达式)：");
        gc.forEach(s -> System.out.print(s+" "));
        System.out.println();

        System.out.println("迭代器遍历：");
        Iterator<String> it = gc.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(it.hasNext()){
                System.out.print(s+",");
            }else{
                System.out.println(s);
            }
        }

        System.out.println(gc); //默认调用toString()方法
        System.out.println();

        //获取集合元素个数
        System.out.println("集合中元素个数："+gc.size());
        //获取集合容量
        System.out.println("集合容量："+gc.getCapacity());

        System.out.println("添加元素gc.add(10,\"C++\")-----------------");
        gc.add(1,"C++");

        System.out.println("集合中元素个数："+gc.size());
        System.out.println("集合容量："+gc.getCapacity());

        //向集合尾部中依次添加多个元素
        gc.addAll("C","C#","golang","php","html","javascript");
        System.out.println("依次添加多个元素--------------------");
        System.out.println("集合中元素个数："+gc.size());
        System.out.println("集合容量："+gc.getCapacity());

        //toString方法
        System.out.println("toString方法：");
        System.out.println(gc); //默认调用toString()方法
        System.out.println("toString_capacity方法：");
        System.out.println(gc.toString_capacity());

        System.out.println();

        System.out.println("-----------------泛型方法测试-------------------");
        generic_function gf = new generic_function() {
            @Override
            public <E, T> void printGf(E e, T t) {
                System.out.println(e.toString()+","+t);
            }

            @Override
            public <E> void addElement(generic_class<E> g, E... es) {
                for(E e:es){
                    g.add(e);
                }
            }
        };
        System.out.println("--------泛型方法1---------");
        int[] arr = {1,2,3,4,5};
        String s = "IDEA";
        int i = 10;
        double d = 3.14;
        gf.printGf(arr,"数组");
        gf.printGf(gc,"集合");
        gf.printGf(s,"字符串");
        gf.printGf(i,"整型");
        gf.printGf(d,"浮点型");
        System.out.println();

        System.out.println("--------泛型方法2---------");
        gf.addElement(gc,"python");
        getInfo(gc);

        System.out.println("-----------------泛型接口测试-------------------");
        System.out.println("删除索引元素：");
        System.out.print("待删除元素索引：");
        int index = sc.nextInt();
        gc.remove(index);
        getInfo(gc);
        System.out.println("-------------------------------------------");
        System.out.println("删除最大索引元素：");
        gc.remove();
        getInfo(gc);
        System.out.println("-------------------------------------------");
        System.out.println("删除指定元素java：");
        gc.remove("java");
        getInfo(gc);
        System.out.println("-------------------------------------------");
        System.out.println("删除所有指定元素java：");
        int[] javaIndexs = gc.removeAllElement("java");
        System.out.println("javaIndexs="+Arrays.toString(javaIndexs));
        getInfo(gc);
        System.out.println("-------------------------------------------");
        System.out.println("删除所有指定索引的元素");
        Object[] str = gc.removeAll(0,1,2);
        System.out.println("elements="+Arrays.toString(str));
        getInfo(gc);

    }

    private static void getInfo(generic_class<String> gc) {
        System.out.println("集合元素个数："+ gc.size());
        System.out.println("集合容量："+ gc.getCapacity());
        System.out.println(gc); //默认调用toString()方法
    }


}
