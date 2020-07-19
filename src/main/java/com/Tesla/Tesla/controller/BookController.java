package com.Tesla.Tesla.controller;

import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.repository.BookRepository;
import com.Tesla.Tesla.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;

    }

    @GetMapping("books")
    public String myBook(Model model){
        model.addAttribute("book", new Book());
        return "books";
    }

    @PostMapping("books")
    public String addbook(@ModelAttribute("book") Book book, BindingResult error, Model model)
    {
        if(error.hasErrors())
            return "books";
        bookService.save(book);
        return "books";
    }
}
