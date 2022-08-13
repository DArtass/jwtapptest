package com.petproject.jwtapptest.service;

import com.petproject.jwtapptest.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUserName(String userName);

    User findById(Long id);

    void delete(Long id);
}
