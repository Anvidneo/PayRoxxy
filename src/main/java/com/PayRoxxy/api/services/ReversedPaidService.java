package com.PayRoxxy.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.ReverserdPaidsModel;
import com.PayRoxxy.api.repositories.ReversedPaidRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReversedPaidService {
    @Autowired
    ReversedPaidRepository reversedPaidRepository;

    public ArrayList<ReverserdPaidsModel> getReversedPaids(){
        return (ArrayList<ReverserdPaidsModel>)reversedPaidRepository.findAll();
    }

    public ReverserdPaidsModel saveReversedPaid(ReverserdPaidsModel reversion){
        return reversedPaidRepository.save(reversion);
    }

    public Integer getLastId(){
        ArrayList<ReverserdPaidsModel> reversions = (ArrayList<ReverserdPaidsModel>) reversedPaidRepository.findAll();
        Integer cantReversions = reversions.size();
        return reversions.get(cantReversions-1).getId();
    }

    public boolean deleteReversion(Integer id){
        try {
            reversedPaidRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Boolean getByIdifExists(Integer id){
        Integer rId = null;
        Optional<ReverserdPaidsModel> reversion = reversedPaidRepository.findById(id);
        if(reversion.isPresent()){
            rId = reversion.get().getId();
            if (rId != null) {
                return true; 
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
