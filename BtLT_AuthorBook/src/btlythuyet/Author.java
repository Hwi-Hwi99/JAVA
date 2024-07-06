/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btlythuyet;

public class Author 
{
    private String name; 
    private String email; 
    private char gender;
    
    public Author() {}
    public Author (String name, String email, char gender)
    {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void getEmail(String email)
    {
        this.email = email;
    }
    public char getGender()
    {
        return this.gender;
    }
    
    @Override
    public String toString()
    {
       return "Author[name = this.name, email = this.email, gender = this.gender]";        
    }
}
