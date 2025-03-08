package Annotation;

import org.junit.jupiter.api.Test;

/**
 * @author TuanFans
 * &#064;date 2025/3/8
 */
// 元注解：用于指定其他注解的属性
// 元注解的种类（使用不多，了解，不用深入研究）
//  1) Retention 指定注解的作用范围，三种SOURCE,CLASS，RUNTIME
//        包含一个RetentionPolicy类型的成员变量，该属性表示注解的保留范围；
//        @Retention的值：
//        （1）RetentionPolicy.SOURCE：在源文件保留，即在.java文件保留，编译成.class文件时，注解信息被遗弃；
//        （2）RetentionPolicy.CLASS：在class文件中保留，即在.class文件保留，编译成.class文件时，注解信息被遗弃，默认值；
//        （3）RetentionPolicy.RUNTIME：在运行时保留，即在.class文件保留，运行时jvm加载class文件时，注解信息被遗弃；
//  2) Target 指定注解可以在哪些地方使用
//  3) Documented 指定该注解是否会在javadoc体现
//  4) Inherited 子类会继承父类注解:
//      被它修饰的Annotation将具有继承性.如果某个类使用了被@lnherited修饰的Annotation，则其子类将自动具有该注解
@SuppressWarnings("all")
public class Annotation02 {
    //测试类 名称 'Annotation02' 不匹配正则表达式 '[A-Z][A-Za-z\d]*Test(s|Case)?|Test[A-Z][A-Za-z\d]*|IT(.*)|(.*)IT(Case)?'
    public void eat(){
        System.out.println("测试吃这个方法！");
    }
    @Test
    public void eatTest(){
        eat();
    }
}
