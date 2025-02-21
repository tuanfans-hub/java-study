package set_java.myGeneric.generic_practice;

public class Dog extends animal{
    private final String action;  //在吃东西的同时的其他行为
    public Dog(String variety, String name,int age,String food,String action) {
        setVariety(variety);
        setName(name);
        setAge(age);
        setFood(food);
        this.action = action;
    }

    @Override
    public void eat() {
        System.out.println("一只名字叫："+getName()+"，年龄："+getAge()+"岁的"+getVariety()+",正在吃"+getFood()+",边吃边"+action);
    }

}
