package com.Tesla.Tesla.service;

import com.Tesla.Tesla.model.User;
import com.Tesla.Tesla.controller.RegisterController;

public interface UserService {

    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);
    void save(User user);

}
