package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> findAll(@PathParam("pageNum") int pageNum,@PathParam("pageSize") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.findAllPage();
        return users;

    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable int userId) {
        return  userMapper.findByID(userId);
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
        userMapper.addUser(user);
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@RequestBody User user,@PathVariable int userId) {
        userMapper.updateUser(user,userId);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable int userId) {
        userMapper.deleteUser(userId);
    }
}

