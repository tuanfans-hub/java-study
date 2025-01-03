package PackageJava;
//封装：类中属性私有化，外界通过setter和getter方法设置和获取属性值。

/*
  构造方法：1.构造方法的名称必须与类名一致
          2.构造方法名称前不能有任何返回值类型的声明
          3.不能在构造方法中使用return返回一个值，但是可以单独写return语句作为方法的结束
          在创建对象时，构造方法被自动调用
*/

public class PackageStudent {
    private String name;
    private int age;
    private String sex;

    //构造方法
    public PackageStudent(){

        System.out.println("构造方法已执行!");
    }
    public PackageStudent(String name,int age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    //构造方法的重载：在一个类中可以定义多个构造方法，只要每个构造方法的参数类型或参数个数不同即可

    //间接访问方式
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age>=0) {
            this.age = age;
        }else{
            System.out.println("年龄数据错误！");
        }
    }

    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }

    public void show(){
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
        System.out.println("性别："+sex);
        System.out.println("未见全貌，不做置评。");
    }
}
