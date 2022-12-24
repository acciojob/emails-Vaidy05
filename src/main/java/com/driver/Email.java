package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword==password){
            if(newPassword.length()>7){
                int uppercase = 0;
                int lowercase = 0;
                int digit = 0;
                int specialchar = 0;
                for(int i=0;i<newPassword.length();i++){
                    if(newPassword.charAt(i)>=65 && newPassword.charAt(i)<=90)
                        uppercase++;
                    else if(newPassword.charAt(i)>=97 && newPassword.charAt(i)<=122)
                        lowercase++;
                    else if(Character.isDigit(newPassword.charAt(i)))
                        digit++;
                    else
                        specialchar++;
                }
                if(uppercase>0 && lowercase>0 && digit>0 && specialchar>0) {
                    this.password=newPassword;
                    System.out.println("Password successfully changed");
                }
                else {
                    System.out.println("New Password should have at least one uppercase, one lowercase, one digit and one special character ");
                    return;
                }
            }
            else{
                System.out.println("Length of the new password should be more than or equal to 8 character");
                return;
            }
        }
        else{
            System.out.println("Password doesn't match");
            return;
        }
    }
}
