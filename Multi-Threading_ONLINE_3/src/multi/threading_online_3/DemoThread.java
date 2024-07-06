/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multi.threading_online_3;

public class DemoThread implements Runnable
{
    @Override
    public void run()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName());
        }
    }
}
