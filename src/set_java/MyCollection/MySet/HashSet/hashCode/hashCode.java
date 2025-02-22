package set_java.MyCollection.MySet.HashSet.hashCode;

import set_java.MyCollection.MySet.HashSet.Student;

/**
 * 哈希值：对象的整数表现形式
 *  hashCode方法的值，就是对象的哈希值
 *  根据hashCode方法算出来的int类型的整数
 *  该方法定义在Object类中，所有对象都可以调用，默认使用地址值进行计算
 *  一般情况下，会重写hashCode方法，利用对象内部的属性值计算哈希值
 * 对象的哈希值特点：
 *  如果没有重写hashCode方法，不同对象计算出的哈希值是不同的
 *  如果已经重写hashcode方法，不同的对象只要属性值相同，计算出的哈希值就是一样的
 *  在小部分情况下，不同的属性值或者不同的地址值计算出来的哈希值也有可能一样。(哈希碰撞)
 * */
public class hashCode {
    public static void main(String[] args){
        //创建对象
        Student s1 = new Student("林青霞",35);
        Student s2 = new Student("林青霞",35);
        Student s3 = new Student("鞠婧祎",22);
        Student s4 = new Student("毛晓彤",18);

        //如果没有重写hashCode方法，不同对象计算出的哈希值是不同的
        //如果已经重写hashcode方法，不同的对象只要属性值相同，计算出的哈希值就是一样的
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        System.out.println("-----------------------------");
        //在小部分情况下，不同的属性值或者不同的地址值计算出来的哈希值也有可能一样。(哈希碰撞)
        System.out.println("abc".hashCode());
        System.out.println("acD".hashCode());
    }
}
