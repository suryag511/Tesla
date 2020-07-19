package com.Tesla.Tesla.service;

import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.controller.RegisterController;
import com.Tesla.Tesla.controller.BookController;

public interface BookService {

    Book findById(long id);
    Book findByBookname(String bookname);
    Book findByPublisher(String publisher);
    void save(Book book);

}
