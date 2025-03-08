package Annotation;

/**
 * @author TuanFans
 * &#064;date 2025/3/8
 */

//1）注解（Annotation）也被称为元数据（Metadata），用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息。
//2）和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息。
//3）在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE中注解占据了更重要的角色，例如用来配置应用程
//   序的任何切面，代替javaEE旧版中所遗留的繁代码和XML配置等。
// 使用Annotation时要在其前面增加@符号，并把该Annotation当成一个修饰符使用。用于修饰它支持的程序元素
// 三个基本的Annotation:
//    1）@Override：限定某个方法，是重写父类或接口方法，该注解只能用于方法
//    2）@Deprecated：用于表示某个程序元素（类，方法等）已过时
//    3）@SuppressWarnings:抑制编译器警告
@SuppressWarnings("all")
// @SuppressWarnings("all")：表示忽略警告，即不报警告，该注解用于抑制编译器警告
// 作用范围：与该注释放置的位置相关
/* @SuppressWarnings源码：
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    String[] value(); --> 该注解的参数，可以指定多个警告类型
}
 */
public class Annotation01 {
    public static void main(String[] args){
        Father f = new Son();
        f.method();
        f.eat();
    }
}

@SuppressWarnings("all")
@Deprecated
// Father类已过时，不建议使用，被弃用
class Father{
    public void method(){
        System.out.println("Father");
    }

    @Deprecated
    // @Deprecated注解：表示某个元素（可以是包、类、字段、方法、属性等）已过时，但是仍然可以使用，只是不建议使用
    // 作用：实现新旧版本的兼容性，用于版本升级过度
    /* @Deprecated注解源码：
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
                    构造器        字段       局部变量      方法      包      模块       参数     类型
    public @interface Deprecated {
        String since() default "";
        boolean forRemoval() default false;
    }
     */
    public void eat(){
        System.out.println("该方法已被弃用！");
    }
}

@SuppressWarnings("all")
class Son extends Father{
    /* @Override源码：
    @Target(ElementType.METHOD) --> 说明该注解只能用于方法，修饰注解的注解，称为元注解
    @Retention(RetentionPolicy.SOURCE)
    public @interface Override {
    }
     */
    @Override
    public void method(){
        System.out.println("Son");
    }
}
