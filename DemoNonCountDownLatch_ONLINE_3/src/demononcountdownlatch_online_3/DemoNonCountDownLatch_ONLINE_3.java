/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demononcountdownlatch_online_3;

public class DemoNonCountDownLatch_ONLINE_3 
{
    private int count = 1000000;
    public void dem()
    {
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 500000; i++)
                {
                    count--;
                }
            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
                for (int i = 0; i < 500000; i++)
                {
                    count--;
                }
            }
        });
        t1.start();
        t2.start();
        
        try
        {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}
        System.out.println("Count = " + count);
    }
    
    public static void main(String[] args) 
    {
        DemoNonCountDownLatch_ONLINE_3 demoNonCountDownLatch = new DemoNonCountDownLatch_ONLINE_3();
        demoNonCountDownLatch.dem();
    }
    
}
