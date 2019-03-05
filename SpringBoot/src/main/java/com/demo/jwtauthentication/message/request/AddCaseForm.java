package com.demo.jwtauthentication.message.request;

import com.demo.jwtauthentication.model.User;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class AddCaseForm {

    @NotBlank
    private String text;

    @NotBlank
    private Date Date;

    @NotBlank
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String author) {
        this.username = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
