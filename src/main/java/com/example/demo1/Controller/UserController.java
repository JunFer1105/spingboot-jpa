package com.example.demo1.Controller;

import com.example.demo1.Dao.IUserDao;
import com.example.demo1.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserDao userDao;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDao.getUser();
    }

}
