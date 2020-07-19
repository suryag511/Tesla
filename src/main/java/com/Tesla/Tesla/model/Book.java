package com.Tesla.Tesla.model;


import com.sun.istack.NotNull;
import lombok.Data;
import com.Tesla.Tesla.controller.RegisterController;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @NotNull
    @Column
    private String bookname;

    @NotNull
    @Column
    private String publisher;

    @NotNull
    @Column
    private String publish_year;

    @NotNull
    @Column
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(String publish_year) {
        this.publish_year = publish_year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
