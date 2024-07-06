/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multi.threading_online_3;

public class ShareThread implements Runnable
{
    private int shareVariable = 0;
    public int getShareVariable()
    {
        return shareVariable;
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println("ID" + Thread.currentThread().getId() 
                    + ", Name" + Thread.currentThread().getName()
                    + ", shareVariable = " + shareVariable);
            shareVariable += 2;
        }
    }
}
