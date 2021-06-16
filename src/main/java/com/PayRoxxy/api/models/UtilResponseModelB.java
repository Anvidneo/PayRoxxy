package com.PayRoxxy.api.models;

import java.util.ArrayList;

public class UtilResponseModelB {
    // Variables de instancia
    private String codSearch;
    private String codService;
    private Double amountOwed;
    private Double amountMinimum;
    private Double amountCommission;
    private String nameClient;
    private ArrayList<QuotaModel> list;

    // public UtilResponseModelL(String codSearch, String codService, Double amountOwed, Double amountMinimum, Double amountCommission, String nameClient, ArrayList<ListModel>list){
    //     this.codSearch = codSearch;
    //     this.codService = codService;
    //     this.amountOwed = amountOwed;
    //     this.amountMinimum = amountMinimum;
    //     this.amountCommission = amountCommission;
    //     this.nameClient = nameClient;
    //     this.list = list;
    // }

    // Get elemets
    public String getCodSearch() {
        return codSearch;
    }

    public String getCodService() {
        return codService;
    }

    public Double getAmountOwed() {
        return amountOwed;
    }

    public Double getAmountMinimum() {
        return amountMinimum;
    }

    public Double getAmountComission() {
        return amountCommission;
    }

    public String getNameClien(){
        return nameClient;
    }

    public ArrayList<QuotaModel> getList(){
        return list;
    }

    // Set elements
    public void setCodSearch(String codSearch) {
        this.codSearch = codSearch;
    }

    public void setCodService(String codService) {
        this.codService = codService;
    }

    public void setAmountOwed(Double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public void setAmountMinimum(Double amountMinimum) {
        this.amountMinimum = amountMinimum;
    }

    public void setAmountComission(Double amountCommission) {
        this.amountCommission = amountCommission;
    }

    public void setNameClien(String nameClient){
        this.nameClient = nameClient;
    }
    
    public void setList(ArrayList<QuotaModel> list){
        this.list = list;
    }

}
