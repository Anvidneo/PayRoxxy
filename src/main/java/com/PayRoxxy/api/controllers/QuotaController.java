package com.PayRoxxy.api.controllers;

import com.PayRoxxy.api.services.QuotaService;

import java.util.ArrayList;
import java.util.Optional;

import com.PayRoxxy.api.models.QuotaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotas")
public class QuotaController {
    @Autowired
    QuotaService quotaService;

    @GetMapping()
    public ArrayList<QuotaModel> getQuotas(){
        return this.quotaService.getQuotas();
    }

    @PostMapping()
    public QuotaModel saveQuota(@RequestBody QuotaModel quota) {
        return this.quotaService.saveQuota(quota);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<QuotaModel> getQuotaById(@PathVariable("id") Integer id) {
        return this.quotaService.getById(id);
    }

    @GetMapping(path = "/amount/{idUser}")
    public Double getAmountTotalByUser(@PathVariable("idUser") Integer idUser){
        return this.quotaService.getAmountTotalByUser(idUser);
    }
}
