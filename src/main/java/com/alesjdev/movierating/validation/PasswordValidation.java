package com.alesjdev.movierating.validation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordValidation {

    @NotBlank(message = "Must specify a password")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    @Size(max = 70, message = "Password must be 70 characters at max")
    private String password;

    @NotBlank(message = "Must specify a password")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    @Size(max = 70, message = "Password must be 70 characters at max")
    private String newPassword1;


    @NotBlank(message = "Must specify a password")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    @Size(max = 70, message = "Password must be 70 characters at max")
    private String newPassword2;


    // Getters and Setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
}
