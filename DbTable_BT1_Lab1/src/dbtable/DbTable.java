/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbtable;

public class DbTable 
{
    public static void main(String[] args) 
    {
        //In cột
        System.out.print("    |"); //in ký tự phân cách dọc đầu tiên
        for (int i = 1; i <= 9; i++)
        {
            System.out.printf("%4d", i); //khoảng cách các số là 4 space
        }
        System.out.println();
        
        //In đường ngang
        System.out.print("----+"); //in phần đầu
        for (int i = 1; i <= 9; i++)
        {
            System.out.print("----"); //in phần kẻ phiá sau dựa trên %4d
        }
        System.out.println();
        
        //In bảng cửu chương
        for (int i = 1; i <= 9; i++)
        {
            //In tiêu đề hàng
            System.out.printf("%2d  |", i);
            
            //while in giá trị từng ô trong hàng
            int j = 1;
            while (j <= 9)
            {
                System.out.printf("%4d", i * j);
                j++;
            }
            System.out.println();
        }
    }
}
