package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author TuanFans
 * &#064;date 2025/4/11
 * &#064description 获取Constructor(构造方法)
 */
public class T02_GetConstructor {
    public static void main(String[] args) {
        /*
            Class类中用于获取构造方法的方法
            Constructor<?>[] getConstructors()：返回所有公共构造方法对象的数组
            Constructor<?>[] getDeclaredConstructors()：返回所有构造方法对象的数组
            Constructor<T> getConstructor(Class<?>...parameterTypes)：返回单个公共构造方法对象
            Constructor<T> getDeclaredConstructor(Class<?>..parameterTypes)：返回单个构造方法对象
        */
        // 获取构造方法
        System.out.println("-----------获取所有公共构造方法对象-----------");
        Constructor<?>[] constructors = Person.class.getConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }
        System.out.println("-----------获取所有构造方法对象-----------");
        Constructor<?>[] allConstructors = Person.class.getDeclaredConstructors();
        for(Constructor<?> constructor : allConstructors){
            System.out.println("***********************");
            System.out.println(constructor);
            // 获取构造方法修饰符：返回构造方法修饰符的int值
            int modifiers = constructor.getModifiers();
            System.out.println(modifiers);
            // 获取构造方法参数个数
            int parameterCount = constructor.getParameterCount();
            System.out.println(parameterCount);
            // 获取构造方法参数类型：返回一个包含所有构造方法参数类型的Class对象数组,如果没有参数，返回0
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for(Class<?> parameterType : parameterTypes){
                System.out.println(parameterType);
            }

        }
        System.out.println("-----------获取单个公共构造方法对象（不含私有）-----------");
        Constructor<Person> constructor1 = null;
        Constructor<Person> constructor2 = null;
        try {
            constructor1 = Person.class.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.getMessage();
        }
        try{
            constructor2 = Person.class.getConstructor(String.class,int.class);
        }catch(Exception e){
            e.getMessage();
        }
        System.out.println(constructor1);
        System.out.println(constructor2);
        System.out.println("-----------获取单个公共构造方法对象（包含私有）-----------");
        Constructor constructor3 = null;
        try{
            constructor3 = Person.class.getDeclaredConstructor(String.class);
        }catch(Exception e){
            e.getMessage();
        }
        System.out.println(constructor3);
        // 创建对象
        Person tuanfans = null;
        // 暴力反射：临时取消访问权限校验
        //Method和Field、Constructor对象都有setAccessible()方法
        //setAccessible作用是启动和禁用访问安全检查的开关
        //参数值为true表示反射的对象在使用时取消访问检查，提高反射的效率。参数值为false则表示反射的对象执行访问检查
        constructor3.setAccessible(true);
        try {
            tuanfans = (Person)constructor3.newInstance("TuanFans");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tuanfans);
    }

}
