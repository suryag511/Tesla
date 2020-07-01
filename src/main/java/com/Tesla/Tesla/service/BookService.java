package com.Tesla.Tesla.service;
import java.util.List;
import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.controller.RegisterController;

public interface BookService {

    public void addBook(Book book);
    public Book getBook(Integer bookId);
    public Book updateBook(Integer BookId, Book book);
    public void deleteBook(Integer bookId);
    public List<Book> getAllBooks();

}
