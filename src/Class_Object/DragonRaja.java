package Class_Object;

import java.util.Objects;

public class DragonRaja {
    private String name;
    private int age;

    public DragonRaja(String name,int age){
        this.name=name;
        if(age>=0) {
            this.age = age;
        }else{
            System.out.println("年龄信息错误！");
        }
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        if(age>=0){
            this.age=age;
        }else{
            System.out.println("年龄信息错误！");
        }
    }

    @Override
    public String toString() {
        return "DragonRaja{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DragonRaja that = (DragonRaja) o;

        if (age != that.age) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
