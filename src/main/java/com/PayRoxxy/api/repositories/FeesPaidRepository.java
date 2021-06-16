package com.PayRoxxy.api.repositories;

import java.util.ArrayList;

import com.PayRoxxy.api.models.FeesPaidModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesPaidRepository extends CrudRepository<FeesPaidModel, Integer> {
    public abstract ArrayList<FeesPaidModel> findByIdQuota(Integer idQuota);
}
