package com.PayRoxxy.api.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.PayRoxxy.api.models.QuotaModel;
import com.PayRoxxy.api.repositories.QuotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotaService {
    @Autowired
    QuotaRepository quotaRepository;

    public ArrayList<QuotaModel> getQuotas(){
        return (ArrayList<QuotaModel>)quotaRepository.findAll();
    }

    public QuotaModel saveQuota(QuotaModel quota){
        return quotaRepository.save(quota);
    }

    public Optional<QuotaModel> getById(Integer id){
        return quotaRepository.findById(id);
    }
    
    public Boolean getByIdifExists(Integer id){
        Integer qId = null;
        Optional<QuotaModel> quota = quotaRepository.findById(id);
        if(quota.isPresent()){
            qId = quota.get().getNumQuota();
            if (qId != null) {
                return true; 
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ArrayList<QuotaModel> getByIdUser(Integer idUser){
        return (ArrayList<QuotaModel>)quotaRepository.findByUserId(idUser);
    }

    public Double getAmountTotalByUser(Integer idUser){
        // Get quotas of User
        ArrayList<QuotaModel> quotas = quotaRepository.findByUserId(idUser);
        Double Amount = 0.0;

        for (QuotaModel quota : quotas) {
            String ExpirationDate = quota.getExpirationDate();
            Date dateExp;
            try {
                // Get and parse expiration date
                dateExp = new SimpleDateFormat("yyyyMMdd").parse(ExpirationDate);
                Date dateNow = new Date();  
                // Validate if expiration date < date now
                if (dateExp.after(dateNow)) {
                    Amount += quota.getAmountCuota();
                }
            } catch (ParseException e) {
                // In case of error in parse return 0
                return 0.0;
            }  
        }

        return Amount;
    }

}
