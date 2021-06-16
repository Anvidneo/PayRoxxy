package com.PayRoxxy.api.controllers;

import com.PayRoxxy.api.services.EntityService;

import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.EntityModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entitys")
public class EntityController {
    @Autowired
    EntityService entityService;

    @GetMapping()
    public ArrayList<EntityModel> getEntitys(){
        return this.entityService.getEntitys();
    }

    @PostMapping()
    public EntityModel saveUser(@RequestBody EntityModel entity) {
        return this.entityService.saveEntity(entity);
    }

    @PostMapping(path = "/{id}")
    public Optional<EntityModel> getEntityById(@PathVariable("id") Integer id) {
        return this.entityService.getById(id);
    }

    @GetMapping(path = "/exists/{id}")
    public Boolean getEntityByIdIfExists(@PathVariable("id") Integer id){
        return this.entityService.existById(id);
    }
}
