package com.Tesla.Tesla.service;

import com.Tesla.Tesla.model.User;
import com.Tesla.Tesla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Tesla.Tesla.controller.RegisterController;

@Service
public class UserServiceImpl implements com.Tesla.Tesla.service.UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(long id)
    {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user)
    {
        user.setUsername(user.getUsername().toLowerCase());
        user.setFirstName(user.getFirstName().substring(0,1).toUpperCase() + user.getFirstName().substring(1).toLowerCase());
        user.setLastName(user.getLastName().substring(0,1).toUpperCase() + user.getLastName().substring(1).toLowerCase());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail().toLowerCase());
        System.out.println(user);
        userRepository.save(user);
    }


}
