package com.PayRoxxy.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.EntityModel;
import com.PayRoxxy.api.repositories.EntityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {
    @Autowired
    EntityRepository entityRepository;
    
    public ArrayList<EntityModel> getEntitys(){
        return (ArrayList<EntityModel>)entityRepository.findAll();
    }

    public EntityModel saveEntity(EntityModel entity){
        return entityRepository.save(entity);
    }

    public Optional<EntityModel> getById(Integer id){
        return entityRepository.findById(id);
    }

    public Boolean getByIdifExists(Integer id){
        Integer eId = null;
        Optional<EntityModel> entity = entityRepository.findById(id);
        if(entity.isPresent()){
            eId = entity.get().getId();
            if (eId != null) {
                return true; 
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
