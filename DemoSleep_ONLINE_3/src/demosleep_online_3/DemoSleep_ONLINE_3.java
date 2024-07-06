/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demosleep_online_3;

public class DemoSleep_ONLINE_3 extends Thread
{
    public void run()
    {
        super.run();
        for (int i = 1; i <= 5; i++)
        {
            System.out.println("Đây là Thread thứ " + i);
            System.out.println("Tạm dừng 5000 miliseconds trước khi chuyển sang Thread tiếp theo");
            if (i == 5)
            {
                System.out.println("END!");
            }
            try 
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) 
    {
        DemoSleep_ONLINE_3 t1 = new DemoSleep_ONLINE_3();
        t1.start();
        DemoSleep_ONLINE_3 t2 = new DemoSleep_ONLINE_3();
        t2.start();
        DemoSleep_ONLINE_3 t3 = new DemoSleep_ONLINE_3();
        t3.start();
    }
    
}
