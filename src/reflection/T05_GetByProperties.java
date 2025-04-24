package reflection;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author TuanFans
 * &#064;date 2025/4/11
 * &#064description 通过properties配置文件创建对象
 */
public class T05_GetByProperties {
    public static void main(String[] args) {
        Object person = set();
        System.out.println(person);
    }

    // 通过Person.properties文件创建Person对象
    private static Class<?> createInstance(){
        Properties properties = getProperties();
        String classPath = (String)properties.get("classPath");
        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazz;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("src\\Person.properties");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        InputStream inputStream = T05_GetByProperties.class.getClassLoader().getResourceAsStream("Person.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    // 给Person对象赋值
    public static Object set(){
        Properties properties = getProperties();
        Class<?> clazz = createInstance();
        // 创建对象
        Person person = null;
        try {
            person = (Person)clazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取属性名
        String name = (String)properties.get("name");
        int age = Integer.parseInt((String)properties.get("age"));
        Field fieldName = null;
        Field fieldAge = null;
        try {
            fieldName = clazz.getField("name");
            fieldAge = clazz.getDeclaredField("age");
            // 暴力反射：设置私有属性可访问
            fieldAge.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            fieldName.set(person,name);
            fieldAge.set(person,age);
        }catch(Exception e){
            e.printStackTrace();
        }
        return person;
    }
}
