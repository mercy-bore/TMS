package com.transportsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {


    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String password;
    @Transient
    private String confirmPassword;
    @Column
    private String phone;
    @Column
    private String email;





    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" + " username='" + getUsername() + "'" + ", firstName='" + getFirstName() + "'" + ", lastName='" + getLastName() + "'" + ", password='" + getPassword() + "'" + ", confirmPassword='" + getConfirmPassword() + "'" + ", phone='" + getPhone() + "'" + ", email='" + getEmail() + "'" + "}";
    }

}


