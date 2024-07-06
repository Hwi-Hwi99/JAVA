/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jointhread_online_3;

public class JoinThread_ONLINE_3 extends Thread
{
    public void run()
    {
        super.run();
        System.out.println(Thread.currentThread().getName() + " đang chạy.");
        {
            try 
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("END! " + Thread.currentThread().getName());
        }
    }
    
    public static void main(String[] args) 
    {
        JoinThread_ONLINE_3 t1 = new JoinThread_ONLINE_3();
        t1.setName("Thread 1");
        t1.start();
        try
        {
            t1.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        JoinThread_ONLINE_3 t2 = new JoinThread_ONLINE_3();
        t2.setName("Thread 2");
        t2.start();
        try
        {
            t2.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        JoinThread_ONLINE_3 t3 = new JoinThread_ONLINE_3();
        t3.setName("Thread 3");
        t3.start();
        try
        {
            t3.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }   
}
