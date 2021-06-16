package com.PayRoxxy.api.models;

public class UtilConsultModelR {
    private String codSearch;
    private Integer idPay;
    private Integer idReversion;
    private String dateReversion;

    // Get elements 
    public String getCodSearch(){
        return codSearch;
    }

    public Integer getIdPay(){
        return idPay;
    }

    public Integer getIdReversion(){
        return idReversion;
    }

    public String getDateReversion(){
        return dateReversion;
    }

    // Set elements
    public void setcodSearch(String codSearch){
        this.codSearch = codSearch;
    }

    public void setidPay(Integer idPay){
        this.idPay = idPay;
    }

    public void setidReversion(Integer idReversion){
        this.idReversion = idReversion;
    }

    public void setdateReversion(String dateReversion){
        this.dateReversion = dateReversion;
    }

}
