package com.example.demo1.Controller;

import com.example.demo1.Dao.UserDao;
import com.example.demo1.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserDao userDao;
    @RequestMapping(value = "auth/login", method = RequestMethod.POST)
    public String createUser(@RequestBody User user){
        return userDao.verifyEmail(user)?"OK":"ERROR";
    }
}
