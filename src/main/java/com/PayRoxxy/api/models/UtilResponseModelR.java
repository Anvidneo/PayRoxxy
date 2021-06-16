package com.PayRoxxy.api.models;

public class UtilResponseModelR {
    private String codSearch;
    private Integer idTxnNeivorReversion;
    private Integer idTxnReversed;

    // public UtilResponseModelR(String codSearch, Integer idTxnNeivorReversion, Integer idTxnReversed){
    //     this.codSearch = codSearch;
    //     this.idTxnNeivorReversion = idTxnNeivorReversion;
    //     this.idTxnReversed = idTxnReversed;
    // }
    
    // Get elements
    public String getCodSearch(){
        return codSearch;
    }
    
    public Integer getIdTxnNeivorReversion(){
        return idTxnNeivorReversion;
    }
    
    public Integer getIdTxnReversed(){
        return idTxnReversed;
    }
    
    // Set elements    
    public void setCodSearch(String codSearch){
        this.codSearch = codSearch;
    }
    
    public void setIdTxnNeivorReversion(Integer idTxnNeivorReversion){
        this.idTxnNeivorReversion = idTxnNeivorReversion;
    }
    
    public void setIdTxnReversed(Integer idTxnReversed){
        this.idTxnReversed = idTxnReversed;
    }
}
