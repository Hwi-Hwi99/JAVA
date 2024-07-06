/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package output_bt3_lab1;

public class Output_BT3_Lab1 {
    public static void main(String[] args) 
    {
        //Sử dụng for tạo các dòng
        for (int i = 0; i < 5; i++) //(int i = 0; i < 10; i++)
        {
            //dòng 1 - 2 chỉ in ****
            if (i < 2) //(i < 1)
            {
                System.out.print("****");
            }
            else 
            {
                for (int j = i; j > 1; j--) //(int j = i; j > 0; j--)
                {
                    System.out.print(j + " ");
                }
                System.out.print("****");
            }
            System.out.println();
        }
    } 
}
