package com.PayRoxxy.api.controllers;

import com.PayRoxxy.api.services.UserService;

import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Integer id) {
        return this.userService.getById(id);
    }

    @GetMapping("/entity")
    public ArrayList<UserModel> getUsersByEntityId(@RequestParam("entityId") Integer entityId) {
        return this.userService.getUsersByEntityId(entityId);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "User deleted";
        } else {
            return "User not deleted";
        }
    }
}
