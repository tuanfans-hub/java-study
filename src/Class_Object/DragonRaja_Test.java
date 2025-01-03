package Class_Object;
/*
* Object类常用方法：
* 1.boolean equals():判断两对象是否相等
* 2.int hashCode():返回对象的哈希码值
* 3.String toString():打印对象的属性值
* */

public class DragonRaja_Test {
    public static void main(String []args){
        DragonRaja stu1=new DragonRaja("路明非",20);
        DragonRaja stu2=new DragonRaja("路明泽",15);
        DragonRaja stu3=new DragonRaja("路明非",20);

        System.out.println(stu1.toString());//重写toString()之前：Class_Object.DragonRaja@1b6d3586
        System.out.println(stu1);//Class_Object.DragonRaja@1b6d3586
        //调用打印对象，默认打印该对象的toString()

        System.out.println("----------------------------------");

        System.out.println(stu1.equals(stu3));
        //重写equals()之前：false，比较的是stu1与stu3的内存地址值
        //重写equals()之后：true，比较stu1与stu3的属性值

        System.out.println("----------------------------------");

        System.out.println(stu1.hashCode());//重写hashCode()之前：460141958
        System.out.println(stu3.hashCode());//重写hashCode()之前：1163157884
        //重写hashCode()之后,两条输出语句都打印：1108764341
    }
}
