package CodeBlock01;

    //普通代码块：直接在方法或语句中定义的代码块
public class ReCodeBlock {
        public static void main(String[] args) {
            String name="蓝湛";
            System.out.print("姓名："+name);

            //普通代码块：限定变量的生命周期，执行后，代码块中的变量消失，提高内存利用率
            {
                int age=20;
                System.out.println(",年龄："+age);
            }
            //System.out.println(age);在普通代码块之外无法调用代码块内的变量
        }
}
