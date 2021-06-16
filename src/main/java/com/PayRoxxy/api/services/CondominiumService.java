package com.PayRoxxy.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.CondominiumModel;
import com.PayRoxxy.api.repositories.CondominiumRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CondominiumService {
    @Autowired
    CondominiumRepository condominiumRepository;
    
    public ArrayList<CondominiumModel> getUsers(){
        return (ArrayList<CondominiumModel>)condominiumRepository.findAll();
    }

    public CondominiumModel saveUser(CondominiumModel user){
        return condominiumRepository.save(user);
    }

    public Optional<CondominiumModel> getById(Integer id){
        return condominiumRepository.findById(id);
    }
    
    public CondominiumModel getByName(String name){
        return condominiumRepository.findByName(name);
    }
}
