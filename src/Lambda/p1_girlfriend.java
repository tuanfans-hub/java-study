package Lambda;

import java.util.Arrays;

/**
 * 定义数组并存储一些女朋友对象，利用Arrays中的sort方法进行排序
 * 要求1：属性有姓名、年龄、身高。
 * 要求2：按照年龄的大小进行排序，年龄一样，按照身高排序，身高一样按照姓名的字母进行排序。
 * (姓名中不要有中文或特殊字符，会涉及到后面的知识)
 * */
public class p1_girlfriend {
    private String name;
    private int age;
    private int height;

    public p1_girlfriend(){

    }
    public p1_girlfriend(String name,int age,int height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getHeight(){
        return height;
    }

    public p1_girlfriend[] sort(p1_girlfriend[] p1s){
        Arrays.sort(p1s, (p1,p2)->{
           if(p1.getAge()==p2.getAge()){
               return p1.getHeight()!=p2.getHeight()?(p1.getHeight()-p2.getHeight()):p1.getName().compareTo(p2.getName());
           }
           return p1.getAge()-p2.getAge();
        });

        return p1s;
    }

}
