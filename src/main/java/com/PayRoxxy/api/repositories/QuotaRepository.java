package com.PayRoxxy.api.repositories;

import java.util.ArrayList;

import com.PayRoxxy.api.models.QuotaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotaRepository extends CrudRepository<QuotaModel, Integer> {
    public abstract ArrayList<QuotaModel> findByUserId(Integer UserId);
}
