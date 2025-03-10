package set_java.MyCollection.MySet.TreeSet;

public class Student implements Comparable<Student>{
    private String name;
    private int age;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Student s) {
        System.out.println("-------------------");
        System.out.println("this:\t"+this);
        System.out.println("s:\t\t"+s);
        if(this.getAge()==s.getAge()){
            return this.getName().compareTo(s.getName());
        }
        return this.getAge()-s.getAge();
    }
}
