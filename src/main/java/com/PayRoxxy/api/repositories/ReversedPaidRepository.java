package com.PayRoxxy.api.repositories;

import com.PayRoxxy.api.models.ReverserdPaidsModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReversedPaidRepository extends CrudRepository<ReverserdPaidsModel, Integer> {
    
}
