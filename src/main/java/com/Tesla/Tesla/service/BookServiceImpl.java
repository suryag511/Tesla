package com.Tesla.Tesla.service;

import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tesla.Tesla.controller.RegisterController;
import com.Tesla.Tesla.controller.BookController;

@Service
public class BookServiceImpl implements com.Tesla.Tesla.service.BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findByBookname(String bookname) {return bookRepository.findByBookname(bookname); }

    @Override
    public Book findByPublisher(String publisher) {return bookRepository.findByPublisher(publisher); }

    @Override
    public Book findById(long id) {return bookRepository.findById(id); }

    @Override
    public void save(Book book) {

    }
}
