package javaDrawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Year;

/**
 * @author TuanFans
 * &#064;date 2025/3/11
 * 演示通过键盘控制小球移动
 */
@SuppressWarnings("all")
// Java事件监听器
public class Event_ extends JFrame {
    public Event_(){
        this.setTitle("小球移动");
        this.setSize(600,400);
        MyPanel panel = new MyPanel();
        this.add(panel);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    static class Ball {
        private static int x;
        private static int y;
        public static final int WIDTH = 20;
        public static final int HEIGHT = 20;
        public static int getX(){
            return x;
        }
        public static int getY(){
            return y;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
    }

    // KeyListener接口: 键盘监听事件
    static class MyPanel extends JPanel implements KeyListener {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.red);
            move(Ball.getX(),Ball.getY(),g,Ball.WIDTH,Ball.HEIGHT);
        }

        private void move(int x,int y,Graphics g,int width,int height){
            g.fillRect(x, y, width, height);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // 点击事件
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // 按下事件
            int[] movecounts = {-10,10,-10,10}; // 每次移动10px
            if(e.getKeyChar()=='w'){
                // 向上移动
                Ball.y+=movecounts[0];
            }else if(e.getKeyChar()=='s'){
                // 向下移动
                Ball.y+=movecounts[1];
            }else if(e.getKeyChar()=='a'){
                // 向左移动
                Ball.x+=movecounts[2];
            }else if(e.getKeyChar()=='d'){
                // 向右移动
                Ball.x+=movecounts[3];
            }else{
                System.out.println("无效按键");
            }
            this.repaint(); // 重绘：触发paint方法，相当于刷新界面
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // 释放事件
        }
    }
}
