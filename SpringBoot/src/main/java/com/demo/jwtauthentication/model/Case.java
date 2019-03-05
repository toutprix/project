package com.demo.jwtauthentication.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false, updatable = false, unique = true)
    @Expose
    private Integer id;

    @Column(name = "date", nullable = false)
    @Expose
    private Date date;

    @Column(name = "make", nullable = false)
    @Expose
    private String make;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable = false)
    private User userId;

    protected Case(){

    }

    public Case(Date date, String make, User id_user) {
        this.date = date;
        this.make = make;
        this.userId = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
