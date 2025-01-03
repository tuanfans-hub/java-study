package Inherit;

public class Student_Chu extends DragonRaja{
    public void Quotation(){
        System.out.println("语录：敌人是什么?斩开就好了!");
    }

    /*
    * 方法的重写：子类对父类方法的重写
    * 重写的方法应具有相同的方法名、参数列表、返回类型，并且子类重写的方法权限不能比父类方法的权限严格
    * */
    @Override//用于检测是否正确的重写格式
    public void Welcome () {
        System.out.println(super.getName() + "," +super.getSex() + "," + super.getAge()+"，"+"毕业于"+school);
    }
    /*
    * super关键字：用于在子类中访问父类成员
    * 成员变量：super.成员变量
    * 成员方法：super.成员方法
    * 构造方法：super()
    *   */
}
