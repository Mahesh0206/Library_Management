package com.example.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer publicationYear;

//    public Book() {}
//
//    public Book(Long id, String title, String author, Integer publicationYear) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.publicationYear = publicationYear;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public Integer getPublicationYear() {
//        return publicationYear;
//    }
//
//    public void setPublicationYear(Integer publicationYear) {
//        this.publicationYear = publicationYear;
//    }

}
