package com.example.assignment1;

public class User {
    public Integer UserID;
    public String UserEmailAddress;
    public String UserUsername;
    public String UserPassword;
    public String UserPhoneNumber;

    public static String tipe="";
    public User(Integer UserID,String UserEmailAddress,String UserPassword, String UserPhoneNumber, String UserUsername)
    {
         this.UserID=UserID;
         this.UserEmailAddress=UserEmailAddress;
         this.UserPassword=UserPassword;
         this.UserUsername=UserUsername;
         this.UserPhoneNumber=UserPhoneNumber;
    }

    public User(Integer userID, String email, String phone, String username){


    }

    public int getUserID() {
        return UserID;
    }

    public String getUserEmailAddress() {
        return UserEmailAddress;
    }

    public String getUserUsername() {
        return UserUsername;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public String getUserPhoneNumber() {
        return UserPhoneNumber;
    }

    public static String getTipe() {
        return tipe;
    }
}
