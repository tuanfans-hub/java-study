package stream;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description
 */
public class Actor {
    private String name;
    private int age;

    public Actor(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
