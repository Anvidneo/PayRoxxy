package com.PayRoxxy.api.models;

public class ListModel {
    private String DetailQuota;
    private String ExpirationDate;
    private Double AmountQuota;
    private Double AmountComission;

    public String getDetailQuota(){
        return this.DetailQuota;
    }

    public String getExpirationDate(){
        return this.ExpirationDate;
    }

    public Double getAmountQuota(){
        return this.AmountQuota;
    }

    public Double getAmountComission(){
        return this.AmountComission;
    }

    public void setDetailQuota(String DetailQuota){
        this.DetailQuota = DetailQuota;
    }

    public void setExpirationDate(String ExpirationDate){
        this.ExpirationDate = ExpirationDate;
    }

    public void setAmountCuota(Double AmountQuota){
        this.AmountQuota = AmountQuota;
    }

    public void setAmountComission(Double AmountComission){
        this.AmountComission = AmountComission;
    }



}
