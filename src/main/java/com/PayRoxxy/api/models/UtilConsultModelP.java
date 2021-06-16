package com.PayRoxxy.api.models;

public class UtilConsultModelP {
    // Variables de instancia
    private Integer idTransaction;
    private String datePayment;
    private String codSearch;
    private Double amountTotal;
    private String nameInvoice;
    private String nit;
    private String placePayment;
    private ListDetailModel listDetail;


    // Declaración del constructor de clase
    // public UtilConsultModelP(String codService, String codSearch){
    //     this.codService = codService;
    //     this.codSearch  = codSearch;
    // }

    // Get elements
    public Integer getIdTransaction(){
        return idTransaction;
    }

    public String getDatePayment(){
        return datePayment;
    }

    public String getCodSearch(){
        return codSearch;
    }

    public Double getAmountTotal(){
        return amountTotal;
    }

    public String getNameInvoice(){
        return nameInvoice;
    }

    public String getNit(){
        return nit;
    }

    public String getPlacePayment(){
        return placePayment;
    }

    public ListDetailModel getListDetail(){
        return listDetail;
    }

    // Set elemenets
    public void setIdTransaction(Integer idTransaction){
        this.idTransaction = idTransaction;
    }

    public void setDatePayment(String datePayment){
        this.datePayment = datePayment;
    }

    public void setCodSearch(String codSearch){
        this.codSearch = codSearch;
    }

    public void setAmountTotal(Double amountTotal){
        this.amountTotal = amountTotal;
    }

    public void setNameInvoice(String nameInvoice){
        this.nameInvoice = nameInvoice;
    }

    public void setNit(String nit){
        this.nit = nit;
    }

    public void setPlacePayment(String placePayment){
        this.placePayment = placePayment;
    }

    public void setListDetail(ListDetailModel listDetail){
        this.listDetail = listDetail;
    }

}
