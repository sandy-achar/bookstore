package com.challengers.entities;


import com.challengers.util.UniqueIdGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Malika(mxp134930) on 11/6/2015.
 */

@Table(name = "user")
@Entity
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    public User() {
    }

    public User(String userName, String password, String firstName) {
        this.userId = UniqueIdGenerator.generateId();
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
