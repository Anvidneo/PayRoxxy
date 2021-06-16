package com.PayRoxxy.api.services;
import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.FeesPaidModel;
import com.PayRoxxy.api.repositories.FeesPaidRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeesPaidService {
    @Autowired
    FeesPaidRepository feesPaidRepository;
    
    public ArrayList<FeesPaidModel> getFeedsPaid(){
        return (ArrayList<FeesPaidModel>)feesPaidRepository.findAll();
    }

    public FeesPaidModel saveFeedPaid(FeesPaidModel feedPaid){
        return feesPaidRepository.save(feedPaid);
    }

    public Boolean getByIdQuotaIfHave(Integer idQuota){
        Double amount = getAmountAvailableO(idQuota);
        // If amount is 0 return false, not available amount
        if (amount.equals(0.0)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean getByIdifExists(Integer id){
        Integer fpId = null;
        Optional<FeesPaidModel> entity = feesPaidRepository.findById(id);
        if(entity.isPresent()){
            fpId = entity.get().getId();
            if (fpId != null) {
                return true; 
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Double getAmountAvailable(Integer idQuota, Double amountT){
        Double amount = 0.0;
        ArrayList<FeesPaidModel> quotas = feesPaidRepository.findByIdQuota(idQuota);
        Integer cantQuotas = quotas.size();
        if (cantQuotas.equals(0)) {
            return amountT;
        } else {
            for (FeesPaidModel quota : quotas) {
                amount += quota.getAmountPaid();
            }
            return amount;
        }
    }

    public Double getAmountAvailableO(Integer idQuota){
        Double amount = 0.0;
        ArrayList<FeesPaidModel> quotas = feesPaidRepository.findByIdQuota(idQuota);
 
        for (FeesPaidModel quota : quotas) {
            amount += quota.getAmountPaid();
        }
        return amount;
        
    }

    public boolean deleteFeedsPaid(Integer id){
        try {
            feesPaidRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
