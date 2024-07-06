/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multi.threading_online_3;

public class MultiThreading_ONLINE_3 
{
    public static void main(String[] args) 
    {
        /*
        MyThread myThread0 = new MyThread();
        myThread0.start();
        
        MyThread myThread1 = new MyThread();
        myThread1.start();
        
        MyThread myThread2 = new MyThread();
        myThread2.setName("Luồng 2");
        myThread2.start();
        */
        /*
        DemoThread demoThread0 = new DemoThread();
        Thread thread0 = new Thread(demoThread0);
        thread0.start();
        
        DemoThread demoThread1 = new DemoThread();
        Thread thread1 = new Thread(demoThread1);
        thread1.setName("Luồng 1");
        thread1.start();
        
        DemoThread demoThread2 = new DemoThread();
        Thread thread2 = new Thread(demoThread2);
        thread2.start();
        */
        
        ShareThread shareThread = new ShareThread();
        
        Thread thread0 = new Thread(shareThread);
        thread0.setName("Luồng 1");
        thread0.start();
        
        Thread thread1 = new Thread(shareThread);
        thread1.setName("Luồng 2");
        thread1.start();
        
        Thread thread2 = new Thread(shareThread);
        thread2.setName("Luồng 3");
        thread2.start();
        
        System.out.println("Giá trị thuộc tính shareVariable = " + shareThread.getShareVariable());
    }
}
