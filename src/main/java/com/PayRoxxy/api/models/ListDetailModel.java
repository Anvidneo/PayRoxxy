package com.PayRoxxy.api.models;

public class ListDetailModel {
    private Integer invoice;
    private String amountQuota;

    // Declaración del constructor de clase
    // public ListDetailModel(Integer invoice, String amountQuota){
    //     this.invoice = invoice;
    //     this.amountQuota = amountQuota;
    // }


    // Get elements
    public Integer getinvoice(){
        return invoice;
    }

    public String getamountQuota(){
        return amountQuota;
    }

    // Set elements
    public void setinvoice(Integer invoice ){
        this.invoice = invoice;
    }

    public void setamountQuota(String amountQuota ){
        this.amountQuota = amountQuota;
    }

}
