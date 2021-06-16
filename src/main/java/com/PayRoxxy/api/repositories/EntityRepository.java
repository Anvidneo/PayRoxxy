package com.PayRoxxy.api.repositories;

import com.PayRoxxy.api.models.EntityModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository<EntityModel, Integer> {

}
