package Inherit;
/*继承：在现有类的基础上构建出来的新类被称为子类，现有类被称为父类。子类继承了父类的非私有属性和方法
* 声明一个类继承另一个类，使用extends关键字
* 格式：class 父类{...}
*      class 子类 extends 父类{...}
* 特点：1.只支持单继承，不允许多继承，即一个类只能有一个直接父类
*      2.多个类可以继承一个父类
*      3.允许多层继承
* */

public class DragonRaja {
    private String name;
    private String sex;
    private int age;
    static String school;

    public DragonRaja() {
    }

        public String getName () {
            return name;
        }
        public String getSex () {
            return sex;
        }
        public int getAge () {
            return age;
        }
        public void setName (String name){
            this.name = name;
        }
        public void setSex (String sex){
            this.sex = sex;
        }
        public void setAge ( int age){
            if (age >= 0) {
                this.age = age;
            } else {
                System.out.println("年龄信息错误！");
            }
        }

        public void Welcome () {
            System.out.println(name + "," + sex + "," + age + "," + "毕业于" + school);
        }
}
