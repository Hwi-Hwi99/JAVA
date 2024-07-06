/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer_online_3;

public class Customer_ONLINE_3 
{
    private int taiKhoan = 10000;
    public Customer_ONLINE_3()
    {
        System.out.println("Tài khoản hiện có = " + taiKhoan);
    }
    
    private synchronized void rutTien(int soTienRut)
    {
        System.out.println("Giao dịch rút tiền đang được thực hiện với" 
                + "số tiền = " + soTienRut + "...");
        
        if (taiKhoan < soTienRut)
        {
            System.out.println("Số tiền trong tài khoản không đủ!");
            try
            {
                wait();
            } catch (InterruptedException ie)
            {
                System.out.println(ie.toString());
            }
        }
        taiKhoan -= soTienRut;
        System.out.println("Rút tiền thành công. Số tiền hiện có trong tài khoản = " + taiKhoan);
    }
    
    private synchronized void nopTien(int soTienNop)
    {
        System.out.println("Giao dịch nộp tiền đang được thực hiện với" 
                + "số tiền = " + soTienNop + "...");
        taiKhoan += soTienNop;
        System.out.println("Nộp tiền thành công. Số tiền hiện có trong tài khoản = " + taiKhoan);
        notify();
    }
    
    public static void main(String[] args) 
    {
        final Customer_ONLINE_3 customer = new Customer_ONLINE_3();
        Thread t1 = new Thread()
        {
            public void run()
            {
                customer.rutTien(20000);
            }
        };
        t1.start();
        Thread t2 = new Thread()
        {
            public void run()
            {
                customer.nopTien(30000);
            }
        };
        t2.start();
    }
    
}
