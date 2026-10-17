package com.example.librarybackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UsersEntity {

    public UsersEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "email", unique = true)
    public String email;
    @Column(name = "password", unique = true)
    public String password;

    public UsersEntity() {

    }
}
