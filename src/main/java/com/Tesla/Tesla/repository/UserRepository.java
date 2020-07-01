package com.Tesla.Tesla.repository;
import com.Tesla.Tesla.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);

}
