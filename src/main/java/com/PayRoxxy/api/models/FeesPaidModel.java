package com.PayRoxxy.api.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fees_paid")
public class FeesPaidModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String datePaid;
    private String placePaid;
    private Double amountPaid;
    private Integer idQuota;
    private Integer idTransaction;

    // Get elements
    public Integer getId(){
        return id;
    }

    public String getDatePaid(){
        return datePaid;
    }

    public String getPlacePaid(){
        return placePaid;
    }

    public Double getAmountPaid(){
        return amountPaid;
    }

    public Integer getIdQuota(){
        return idQuota;
    }
    
    public Integer getIdTransaction(){
        return idTransaction;
    }

    // Set elements
    public void setId(Integer id){
        this.id = id;
    }

    public void setDatePaid(String datePaid){
        this.datePaid = datePaid;
    }

    public void setPlacePaid(String placePaid){
        this.placePaid = placePaid;
    }

    public void setAmountPaid(Double amountPaid){
        this.amountPaid = amountPaid;
    }

    public void setIdQuota(Integer idQuota){
        this.idQuota = idQuota;
    }
    
    public void setIdTransaction(Integer idTransaction){
        this.idTransaction = idTransaction;
    }

}
