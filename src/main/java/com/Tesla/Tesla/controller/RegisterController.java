package com.Tesla.Tesla.controller;

import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.model.User;
import com.Tesla.Tesla.repository.UserRepository;
import com.Tesla.Tesla.repository.BookRepository;
import com.Tesla.Tesla.service.UserService;
import com.Tesla.Tesla.service.UserServiceImpl;
import com.Tesla.Tesla.service.BookService;
import com.Tesla.Tesla.service.BookServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
public class RegisterController {
    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    public RegisterController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("register")
    public String myRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("register")
    public String registration(@ModelAttribute("user") User user, BindingResult error, Model model){
        //UserValidator uv = new UserValidator();
        //uv.validate(user, error);


        if(error.hasErrors())
           // model.addAttribute(userForm);
            return "register";
         userService.save(user);
        return "index";
    }

    @RequestMapping(value = "/add_book", method = RequestMethod.GET)
    public ModelAndView newBook(ModelAndView model) {
        Book book = new Book();
        model.addObject("book", book);
        model.setViewName("addbook");

        return model;
    }

    @RequestMapping(value = "/save_book", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) {
        if (book.getId() == 0) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book.getId() , book);
        }
        return new ModelAndView("redirect:/books");
    }

    @RequestMapping(value = "/edit_book", method = RequestMethod.GET)
    public ModelAndView updateBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book=bookService.getBook(bookId);
        ModelAndView model = new ModelAndView("addbook");
        model.addObject("book",book);

        return model;
    }

    @RequestMapping(value = "/delete_book", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBook(bookId);
        return new ModelAndView("redirect:/books");
    }


    @RequestMapping("books")
    public String Books(Model model){

        return "books";
    }


}
