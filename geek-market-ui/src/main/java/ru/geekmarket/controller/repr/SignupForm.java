package ru.geekmarket.controller.repr;

import ru.geekmarket.controller.validation.EmailNotRegistered;

import javax.validation.constraints.NotBlank;

public class SignupForm {

    @NotBlank
    @EmailNotRegistered
    private String email;

    public SignupForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
