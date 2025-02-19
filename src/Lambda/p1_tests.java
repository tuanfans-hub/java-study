package Lambda;

public class p1_tests {
    public static void main(String[] args) {
        // 创建一些女朋友对象
        p1_girlfriend[] girlfriends = new p1_girlfriend[]{
            new p1_girlfriend("Alice", 25, 165),
            new p1_girlfriend("Bob", 22, 170),
            new p1_girlfriend("Tom", 25, 160),
            new p1_girlfriend("Diana", 22, 155),
            new p1_girlfriend("Eve", 25, 165)
        };

        // 创建 p1_girlfriend 对象的实例
        p1_girlfriend sorter = new p1_girlfriend();

        // 排序
        girlfriends = sorter.sort(girlfriends);

        // 输出排序后的结果
        for (p1_girlfriend gf : girlfriends) {
            System.out.println("Name: " + gf.getName() + "\t\t\tAge: " + gf.getAge() + "\t\t\tHeight: " + gf.getHeight());
        }
    }
}

