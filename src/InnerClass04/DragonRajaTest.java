package InnerClass04;

public class DragonRajaTest {
    public static void main(String[] args){
        new DragonRaja(){
            public void show(){
                System.out.println("欢迎来到卡塞尔学院！");
            }
        }.show();

        nono(
                new DragonRaja(){
                    @Override
                    public void show(){
                        System.out.println("我是诺诺！");
                    }
                }
        );

        //匿名内部类我们可以理解为接口的实现类对象或者类的子类对象
        Students stu=new Students(){
            @Override
            public void display(){
                System.out.println("血统A级，言灵未知");
            }
        };

        stu.display();
    }

    public static void nono(DragonRaja stu){//DragonRaja stu= 子类对象  多态
        stu.show();//编译看左边，运行看右边
    }

}
