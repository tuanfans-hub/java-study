package myException;

public class TestException {
    public static void main(String[] args) throws MyException {
        //abnormal ab=new Student("诺诺",-20);
        Student ab=new Student();
        ab.setName("诺诺");
        ab.setAge(-10);
        ab.show();
    }
}
