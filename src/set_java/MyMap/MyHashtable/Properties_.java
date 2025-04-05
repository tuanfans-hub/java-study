package set_java.MyMap.MyHashtable;

import java.util.Properties;

/*
Map接口实现类-Properties：
1.Properties类继承自Hashtable类并且实现了Map接口，也是使用一种键值对的形
式来保存数据。
2.他的使用特点和Hashtable类似
3.Properties 还可以用于 从 xxx.properties 文件中, 加载数据到Properties类对象,
并进行读取和修改
4.底层结构：数组+链表/红黑树
* */
public class Properties_ {
    public static void main(String[] args){
        // Properties的底层实现：
        // 1.键和值都不可为null
        // 2.疑惑？：
        //      AI给出的Properties的默认初始容量为11，负载因子为0.75，扩容时容量变为2*容量+1；（经过验证jdk1.8符合该结论）
        //      对此，我通过调试发现在调用无参构造器时，Properties的容量为16，负载因子为0.75，扩容时容量为2*容量+1
        //      （该项目结构的JDK版本为jdk23，通过源代码推断该改动始于jdk10版本）
        Properties prop = new Properties();
        prop.put("key1","value1");
        prop.put("key2","value2");
        prop.put("key3","value3");
        prop.put("key4","value4");
        prop.put("key5","value5");
        prop.put("key6","value6");
        prop.put("key7","value7");
        prop.put("key8","value8");
        prop.put("key9","value9");
        prop.put("key10","value10");
        prop.put("key11","value11");
        prop.put("key12","value12");
        prop.put("key13","value13");
        System.out.println("-----------------------------------------");
        System.out.println(prop);
        System.out.println("-----------------------------------------");
        // 通过键获取值
        // 1.get方法
        System.out.println(prop.get("key10"));
        // 删除键值对
        System.out.println(prop.remove("key1"));
        System.out.println(prop);
        // 修改键值对(添加相同的键，值将被替代)
        System.out.println(prop.put("key2", "value2_new"));
        System.out.println(prop);
    }
}
