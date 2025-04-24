package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author TuanFans
 * &#064;date 2025/4/11
 * &#064description 获取成员变量
 */
public class T03_GetField {
    public static void main(String[] args){
        //Class类中用于获取成员变量的方法:
        //Field[] getFields()：返回所有公共成员变量对象的数组
        System.out.println("-----------获取所有公共成员变量对象-----------");
        Field[] fields = Person.class.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //Field[] getDeclaredFields()：返回所有成员变量对象的数组
        System.out.println("-----------获取所有成员变量对象-----------");
        Field[] declaredFields = Person.class.getDeclaredFields();
        for (Field df : declaredFields) {
            System.out.println(df);
        }
        //Field getField(String name)：返回单个公共成员变量对象
        System.out.println("-----------获取单个公共成员变量对象-----------");
        Field name = null;
        try{
            name = Person.class.getField("name");
        }catch(Exception e){
            e.printStackTrace();
        }
        //Field类中用于创建对象的方法:
        //Object get(Object obj)获取成员变量记录的值。
        Person p = new Person("TuanFans",18);
        String nameValue = null;
        try{
            nameValue = (String)name.get(p);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(name);
        System.out.println(nameValue);
        //void set(Object obj, Object value)： 赋值
        try{
            name.set(p,"XXXXX");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(p);
        //Field getDeclaredField(String name)：返回单个成员变量对象
        System.out.println("-----------获取单个成员变量对象-----------");
        Field age = null;
        try{
            age = Person.class.getDeclaredField("age");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(age);
        // 获取成员变量的属性:
        System.out.println("-----------获取成员变量的属性-----------");
        System.out.println("成员变量age的属性:");
        int modifiers = age.getModifiers();
        System.out.println("age修饰符："+modifiers);
        System.out.println("age的变量名："+age.getName());
        System.out.println("age的数据类型："+age.getType());
        System.out.println("age是否是静态的："+ Modifier.isStatic(modifiers));
        System.out.println("age是否是final修饰的："+Modifier.isFinal(modifiers));
        System.out.println("age是否是public修饰的："+Modifier.isPublic(modifiers));
        System.out.println("age是否是protected修饰的："+Modifier.isProtected(modifiers));
        System.out.println("age是否是private修饰的："+Modifier.isPrivate(modifiers));
        System.out.println("age是否是abstract修饰的："+Modifier.isAbstract(modifiers));




    }
}
