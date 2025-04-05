package javaDrawing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author TuanFans
 * &#064;date 2025/3/10
 * 演示如何在面板上画圆
 */
public class Drawing extends JFrame{ // 窗口类：继承 JFrame类
/*
绘图原理
Component类提供了两个和绘图相关最重要的方法：
1.paint(Graphics g) 绘制组件的外观
2.repaint() 刷新组件的外观。
当组件第一次在屏幕显示的时候，程序会自动的调用paint()方法来绘制组件。
在以下情况paintO将会被调用：
1.窗口最小化后再显示时
2.窗口的大小发生变化时
3.paint函数被调用时
*/
    public Drawing(){
        // 创建一个面板类对象
        MyPanel myPanel = new MyPanel();
        // 指定窗口的大小和位置
        this.setSize(800,600);
        // 将面板放入窗口
        this.add(myPanel);
        // 设置可见
        this.setVisible(true);
        // 设置窗口关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // EXIT_ON_CLOSE：窗口关闭，程序结束
    }
}

// 定义一个面板类（MyPanel）,继承 JPanel类
class MyPanel extends JPanel {
    // 理解说明：
    // MyPanel：画板；
    // Graphics g：画笔，提供了很多绘图的方法
    @Override
    public void paint(Graphics g){  //绘图的方法
        super.paint(g); //调用父类的方法，完成初始化
        g.drawOval(10,10,100,100);  // 画椭圆边框
        g.drawLine(150,10,200,100);    // 画直线
        g.drawRect(200,10,100,100);  // 画矩形边框
        g.setColor(Color.red);  // 设置画笔颜色
        g.fillRect(400,10,100,100); // 填充矩形
        g.fillOval(600,10,150,50);  // 填充椭圆
        // 画图片
        // 获取图片
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("./images/5.png"));
            g.drawImage(img,10,200,this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 设置字体
        g.setFont(new Font("仿宋",Font.BOLD,30));
        g.setFont(new Font("隶书",Font.BOLD,50)); // 覆盖之前设置的字体
        g.drawString("《沧元图》",300,200); // 画字符串

        System.out.println("paint()方法被调用~~~");
    }
}
