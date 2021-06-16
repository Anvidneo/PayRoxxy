package com.PayRoxxy.api.repositories;

import java.util.ArrayList;

import com.PayRoxxy.api.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    public abstract ArrayList<UserModel> findByEntityId(Integer entityId);

    public abstract UserModel findByUserAndPassword(String user, String password);

    public abstract UserModel findByUserAndPasswordAndEntityId(String user, String password, Integer entityId);
}
