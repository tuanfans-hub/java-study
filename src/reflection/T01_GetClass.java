package reflection;

/**
 * @author TuanFans
 * &#064;date 2025/4/11
 * &#064description 反射--获取Class对象
 */
public class T01_GetClass {
    //反射：反射允许对封装类的字段，方法和构造函数的信息进行编程访问。
    //Class也是类，因此也继承object类
    //Class类对象不是new出来的，而是系统创建的
    //对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
    //每个类的实例都会记得自己是由哪个Class实例所生成
    //通过Class可以完整地得到一个类的完整结构，通过一系列API
    //Class对象是存放在堆的
    //类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据（包括方法代码，变量名，方法名，访问权限等）

    //如下类型有Class对象
    //外部类，成员内部类，静态内部类，局部内部类，匿名内部类
    //interface：接口
    //数组
    //enum：枚举
    //annotation：注解
    //基本数据类型
    //void
    public static void main(String[] args) {
        // 获取class对象
        System.out.println("-----------获取class对象(源代码阶段)-----------");
        try{
            // 通过全类名获取
            Class c1 = Class.forName("reflection.Person");
            System.out.println(c1);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("-----------获取class对象(加载阶段)-----------");
        // 一般作为参数使用
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        System.out.println("-----------获取class对象(运行阶段)-----------");
        Person person = new Person();
        // 已有对象实例
        Class<? extends Person> personClass1 = person.getClass();
        System.out.println(personClass1);
        System.out.println("-----------获取class对象(类加载器获取)-----------");
        ClassLoader classLoader = Person.class.getClassLoader();
        Class<?> pClass = null;
        try {
            pClass = classLoader.loadClass("reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(pClass);
        System.out.println("-----------获取class对象(基本数据类型/包装类)-----------");
        // 基本数据类型
        System.out.println(String.class);
        System.out.println(int.class);
        // 包装类
        System.out.println(Integer.TYPE);
        System.out.println("-----------class对象的其他方法-----------");
        classMethods(personClass);
    }

    public static void classMethods(Class<?> clazz){
        // 获取类所在包名
        String packageName = clazz.getPackageName();// since 9.0使用
        String packageName_ = clazz.getPackage().getName();
        System.out.println("packageName = "+packageName);
        System.out.println("packageName_ = "+packageName_);
        // 获取类名
        String clazzName = clazz.getName();
        String simpleName = clazz.getSimpleName();
        System.out.println("clazzName = "+clazzName);
        System.out.println("simpleName = "+simpleName);
        // 创建实例
        Object o1 = null;
        try{
            o1 = clazz.newInstance();// since 9.0废弃
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(o1);
        Object o2 = null;
        try{
            o2 = clazz.getConstructor().newInstance();// since 9.0使用
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(o2);
    }
}
