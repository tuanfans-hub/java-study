package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author TuanFans
 * &#064;date 2025/4/11
 * &#064description 获取成员方法
 */
public class T04_GetMethod {
    public static void main(String[] args){
        //Class类中用于获取成员方法的方法
        //Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
        System.out.println("-----------获取所有公共成员方法对象-----------");
        Method[] methods = Person.class.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }
        //Method[] getDeclaredMethods()：返回所有成员方法对象的数组，不包括继承的
        System.out.println("-----------获取所有成员方法对象-----------");
        Method[] declaredMethods = Person.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
            System.out.println("方法名："+declaredMethod.getName());
            System.out.println("修饰符："+declaredMethod.getModifiers());
            System.out.println("返回值类型："+declaredMethod.getReturnType());
            System.out.println("参数：");
            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameters+" ");
            }
            System.out.println();
            System.out.println("异常：");
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType+" ");
            }
            System.out.println();
            System.out.println("*********************");
        }
        //Method getMethod(String name, Class<?>...parameterTypes）：返回单个公共成员方法对象
        System.out.println("-----------获取单个公共成员方法对象-----------");
        Method show = null;
        try{
            show = Person.class.getMethod("show");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(show);

        //Method getDeclaredMethod(String name, Class<?>...parameterTypes)：返回单个成员方法对象
        System.out.println("-----------获取单个成员方法对象-----------");
        Method showNation = null;
        try{
            showNation = Person.class.getDeclaredMethod("showNation", String.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(showNation);
        //Method类中用于创建对象的方法
        //Object invoke(Object obj, Object... args)： 运行方法
        //参数一：用obj对象调用该方法
        //参数二：调用方法的传递的参数 (如果没有就不写)
        //返回值：方法的返回值 (如果没有就不写)
        Person person = null;
        try {
            person= Person.class.getConstructor(String.class, int.class).newInstance("TuanFans", 20);
            show.invoke(person,null);
            // 暴力反射：调用私有方法
            showNation.setAccessible(true);
            Object invoke = showNation.invoke(person, "江西");
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
