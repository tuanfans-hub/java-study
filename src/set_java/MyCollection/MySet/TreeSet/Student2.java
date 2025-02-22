package set_java.MyCollection.MySet.TreeSet;

public class Student2 {
    private String name;
    private int age;
    private score scores;

    public Student2() {
    }

    public Student2(String name, int age, int Chinese, int Math,int English) {
        this.name = name;
        this.age = age;
        this.scores = new score(Chinese,Math,English);
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

    public int getChinese(){
        return scores.Chinese;
    }
    public int getMath(){
        return scores.Math;
    }
    public int getEnglish(){
        return scores.English;
    }


    public String toString() {
        return "Student2{name = " + name + ", \t\tage = " + age + ", \t\tscores = " + scores + "}";
    }

    public int getSum(){
        return scores.Chinese+scores.Math+scores.English;
    }

    private static class score{
        private int Chinese;
        private int Math;
        private int English;


        public score() {
        }

        public score(int Chinese, int Math, int English) {
            this.Chinese = Chinese;
            this.Math = Math;
            this.English = English;
        }

        public String toString() {
            return "{Chinese = " + Chinese + ", Math = " + Math + ", English = " + English + "}";
        }
    }



}
