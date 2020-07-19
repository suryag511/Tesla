package com.Tesla.Tesla.repository;
import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository <Book,Long>
{
    Book findById(long id);
    Book findByBookname(String bookname);
    Book findByPublisher(String publisher);
}
