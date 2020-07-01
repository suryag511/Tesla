package com.Tesla.Tesla.repository;
import com.Tesla.Tesla.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BookRepository extends CrudRepository <Book, Integer>{

    Book findById(int bookId);

}
