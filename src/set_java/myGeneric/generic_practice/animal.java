package set_java.myGeneric.generic_practice;

public abstract class animal {
    private String variety;
    private String name;
    private int age;
    private String food;


    public animal(){

    }
    public animal(String variety,String name,int age,String food){
        this.variety = variety;
        this.name = name;
        this.age = age;
        this.food = food;
    }

    public void setVariety(String variety){
        this.variety = variety;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setFood(String food){
        this.food = food;
    }

    public String getVariety(){
        return variety;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getFood(){
        return food;
    }

    public abstract void eat();

}
