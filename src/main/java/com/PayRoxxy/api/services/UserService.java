package com.PayRoxxy.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.UserModel;
import com.PayRoxxy.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Integer id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getUsersByEntityId(Integer entityId){
        return userRepository.findByEntityId(entityId);
    }
   
    public UserModel getUserByEntityIdAndEntityId(String user, String password, Integer entityId){
        return userRepository.findByUserAndPasswordAndEntityId(user, password, entityId);
    } 
    
    public boolean deleteUser(Integer id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Integer getIdUser(String user, String password){
        UserModel userObj = userRepository.findByUserAndPassword(user, password);
        return userObj.getId(); 
    } 
}
