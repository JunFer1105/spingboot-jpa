package com.example.demo1.Controller;

import com.example.demo1.Dao.IUserDao;
import com.example.demo1.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserDao userDao;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDao.getAllUser();
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userDao.deleteUser(id);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userDao.createUser(user);
    }
    @RequestMapping(value = "userOld", method = RequestMethod.GET)
    public List<User> getAllUsersOld(){
        return userDao.getUserNoDB();
    }

}
