package thread.sellTicket;

import java.util.Random;

/**
 * @author TuanFans
 * &#064;date 2025/3/18
 * &#064description 售票程序(并发)
 */
// 继承线程类Thread实现售票功能
public class SellTicket extends Thread {
    private int allTickets = 100;
    private final String name;

    public SellTicket(String name){
        this.name = name;
    }
    public void sellTicket(){
        Random rand = new Random();
        int soldTickets = rand.nextInt(10)+10;
        if(allTickets<soldTickets){
            soldTickets = allTickets;
        }
        allTickets -= soldTickets;
        System.out.println(this.name+"售票窗口这次售出"+soldTickets+"张票"+"剩余"+allTickets+"张票！");
    }

    @Override
    public void run() {
        while(allTickets>0){
            sellTicket();
            System.out.println("--------------------------------");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

