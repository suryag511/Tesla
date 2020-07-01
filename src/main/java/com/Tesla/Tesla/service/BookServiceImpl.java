package com.Tesla.Tesla.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) { bookRepository.save(book);}

    @Override
    public Book getBook(Integer bookId){
        return bookRepository.findById(bookId);
    }

    @Override
    public Book updateBook(Integer bookId,Book book) {return bookRepository.save(book);}

    @Override
    public void deleteBook(Integer bookId) { bookRepository.delete(bookId);}

    @Override
    public List<Book> getAllBooks()
    {
        List<Book> books=new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }
}
