package com.example.OnlineClassWebApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {
    @Id
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
}
