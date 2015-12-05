package com.challengers;

/**
 * Created by darkstar on 12/5/15.
 */
public class LoginUser {

    //Attributes for user login class
    private String userName;
    private String password;

    //Constructor for the login class
    public LoginUser() {}

    //Setter and getter methods
    public String getUserName() {

        return userName;

    }

    public String getPassword() {

        return password;

    }

    public void setUserName(String userName) {

        this.userName = userName;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    @Override
    public String toString() {

        return "{User:\n" +
                "UserName:" + userName + "\n" +
                "Password:" + password + "\n" +
                "}";
    }
}
