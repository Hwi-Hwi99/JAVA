/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.util.ArrayList;
import java.util.List;

public class ValidationUpdateStudent {
    public List<String> validateUpdateStudent(Student student) {
        ArrayList<String> err = new ArrayList<String>();
        if (student.getName().isEmpty()) {
            err.add("Name can not be empty");
        } else if (student.getName().length() < 4) {
            err.add("Name is too short");
        } else if (student.getName().length() > 50) {
            err.add("Name is too long");
        } else if (!isString(student.getName())) {
            err.add("Only characters allowed in name");
        }
        if (student.getMailId().isEmpty()) {
            err.add("MailId can not be empty");
        } else if (!isValidEmailAddress(student.getMailId())) {
            err.add("MailId is not valid");
        }
        if (student.getMobileNo().isEmpty()) {
            err.add("Mobile Number can not be empty");
        } else if (student.getMobileNo().length() != 10) {
            err.add("Mobile Number must be 10 digit long");
        } else if (!isDigit(student.getMobileNo())) {
            err.add("Mobile Numbers must have only digits");
        }
        return err;
    }

    public boolean isValidEmailAddress(String email) {
        /*String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-] + @((\\[[0-9]{1,3}\\."
                        + "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)"
                        + "[a-zA-Z]{2,}))$";*/
        String ePattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean isString(String name) {
        String ePattern = "^[\\p{L} '-]+$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(name);
        return m.matches();
    }

    public boolean isStrongPassword(String text) {
        String ePattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(text);
        return m.matches();
    }

    public boolean isDigit(String mobileNo) {
        boolean digits = mobileNo.chars().allMatch(Character::isDigit);
        return digits;
    }
}
