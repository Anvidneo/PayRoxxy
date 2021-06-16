package com.PayRoxxy.api.repositories;

import com.PayRoxxy.api.models.CondominiumModel;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CondominiumRepository extends CrudRepository<CondominiumModel, Integer> {
    public abstract CondominiumModel findByName(String name);
}
