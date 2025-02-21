package set_java.myGeneric.generic_practice;

import java.util.ArrayList;

/**
 * 需求：
 * 定义一个继承结构：
 *                                  动物
 *                          猫              狗
 *                  波斯猫     狸花猫    泰迪     哈士奇
 * 属性：名字，年龄
 * 行为：吃东西
 * 方法体打印：一只叫做XXX的，X岁的波斯猫，正在吃小饼干
 * 方法体打印：一只叫做XXX的，X岁的狸花猫，正在吃鱼
 * 方法体打印：：一只叫做XXX的，X岁的泰迪，正在吃骨头，边吃边蹭
 * 方法体打印：一只叫做XXX的，X岁的哈士奇，正在吃骨头，边吃边拆家
 * 测试类中定义一个方法用于饲养动物
 * public static void keepPet(ArrayList<???> list){
 * //遍历集合，调用动物的eat方法
 * 要求1：该方法能养所有品种的猫，但是不能养狗
 * 要求2：该方法能养所有品种的狗，但是不能养猫
 * 要求3：该方法能养所有的动物，但是不能传递其他类型
 * */
public class generic_practice {
    public static void main(String[] args) {
        Cat bi_si_cat = new Cat("波斯猫","小波",3,"小饼干");
        Cat li_hua_cat = new Cat("狸花猫","阿狸",2,"鱼");
        Dog teddy_dog = new Dog("泰迪","小迪",1,"骨头","蹭");
        Dog erha_dog = new Dog("哈士奇","二哈",3,"骨头","拆家");

        ArrayList<animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();

        cats.add(bi_si_cat);
        cats.add(li_hua_cat);
        dogs.add(teddy_dog);
        dogs.add(erha_dog);

        //要求1
        System.out.println("-----------------要求1-----------------");
        getCat(cats);
        //getCat(animals);错误参数类型
        //要求2
        System.out.println("-----------------要求2-----------------");
        getDog(dogs);
        //getDog(animals);错误参数类型
        //要求3
        System.out.println("-----------------要求3-----------------");
        getAnimal(animals);
        getAnimal(cats);
        getAnimal(dogs);

    }

    //要求1
    public static void getCat(ArrayList<Cat> list){
        for(Cat cat:list){
            cat.eat();
        }
    }

    //要求2
    public static void getDog(ArrayList<Dog> list){
        for(Dog dog:list){
            dog.eat();
        }
    }

    //要求3
    public static void getAnimal(ArrayList<? extends animal> list){
        for(animal a:list){
            a.eat();
        }
    }
}
