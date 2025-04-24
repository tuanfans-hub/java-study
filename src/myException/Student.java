package myException;

public class Student {
    private String name;
    private int age;

    /*
    public abnormal(String name,int age) throws AbnormalClass{
        this.name=name;
        if(age<0){
            throw new AbnormalClass("年龄信息错误：age<0");
        }else {
            this.age = age;
        }
    }
*/
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age) throws MyException {
        if(age<0){
            throw new MyException("年龄信息错误：age<0");
        }else {
            this.age = age;
        }
    }

    public void show(){
        System.out.println(name+","+age);
    }
}
