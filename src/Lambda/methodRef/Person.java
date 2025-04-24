package Lambda.methodRef;

/**
 * @author TuanFans
 * @date 2025/4/22
 * @description
 */
public class Person {
    private String name;
    private Integer age;
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String person){
        String name = person.split(",")[0];
        int age = Integer.parseInt(person.split(",")[1]);
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
