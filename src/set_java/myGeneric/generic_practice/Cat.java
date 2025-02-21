package set_java.myGeneric.generic_practice;

public class Cat extends animal{
    public Cat(String variety,String name,int age,String food){
        this.setVariety(variety);
        this.setName(name);
        this.setAge(age);
        this.setFood(food);
    }

    @Override
    public void eat() {
        System.out.println("一只名字叫："+getName()+"，年龄："+getAge()+"岁的"+getVariety()+",正在吃"+getFood());
    }
}
