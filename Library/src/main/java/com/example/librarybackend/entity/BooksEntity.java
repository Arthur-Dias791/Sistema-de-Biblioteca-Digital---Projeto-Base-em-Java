package com.example.librarybackend.entity;

import jakarta.persistence.*;

@Entity
public class BooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id = null;

    public String title;
    public String subtitle;
    @Column(name = "book_file")
    public byte[] bookFile;
    public String author;
    public String pages;
    public String gender;

}
