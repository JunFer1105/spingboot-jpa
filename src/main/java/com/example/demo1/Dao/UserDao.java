package com.example.demo1.Dao;

import com.example.demo1.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao{
    @Override
    public List<User> getUser() {
        List<User> users = new ArrayList();
        users.add(new User(1,"Juan","email@corre.com",true));
        return users;
    }
}
