/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nonejointhread_online_3;

public class NoneJoinThread_ONLINE_3 extends Thread
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
        NoneJoinThread_ONLINE_3 t1 = new NoneJoinThread_ONLINE_3();
        t1.setName("Thread 1");
        NoneJoinThread_ONLINE_3 t2 = new NoneJoinThread_ONLINE_3();
        t2.setName("Thread 2");
        NoneJoinThread_ONLINE_3 t3 = new NoneJoinThread_ONLINE_3();
        t3.setName("Thread 3");
        
        t1.start();
        t2.start();
        t3.start();
    }
}
