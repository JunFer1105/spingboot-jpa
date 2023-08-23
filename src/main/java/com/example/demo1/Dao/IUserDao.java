package com.example.demo1.Dao;

import com.example.demo1.Model.User;

import java.util.List;

public interface IUserDao {

    List<User> getUserNoDB();
    List<User> getAllUser();
    void deleteUser(Long id);
    void createUser(User user);
    boolean verifyEmail(User user);
}
