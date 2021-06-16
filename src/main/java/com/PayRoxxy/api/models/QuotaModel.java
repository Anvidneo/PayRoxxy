package com.PayRoxxy.api.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_quotas")
public class QuotaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer numQuota;
    private String detailQuota;
    private String expirationDate;
    private Double amountCuota;
    private Double amountComision;
    private Integer userId;

    // Get elemtes
    public Integer getNumQuota(){
        return numQuota;
    }

    public String getDetailQuota(){
        return detailQuota;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    public Double getAmountCuota(){
        return amountCuota;
    }

    public Double getAmountComision(){
        return amountComision;
    }

    public Integer getUserId(){
        return userId;
    }

    // Set elemtes
    public void setNumQuota(Integer numQuota) {
        this.numQuota = numQuota;
    }

    public void setDetailQuota(String detailQuota){
        this.detailQuota = detailQuota;
    }

    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }

    public void setAmountCuota(Double amountCuota){
        this.amountCuota = amountCuota;
    }

    public void setAmountComision(Double amountComision){
        this.amountComision = amountComision;
    }
    
    public void setUserId(Integer userId){
        this.userId = userId;
    }


}
