package com.PayRoxxy.api.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_reversed_paids")
public class ReverserdPaidsModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String dateReverserd;
    private Integer idQuota;
    private Integer idTransaction;

    // Get elements
    public Integer getId(){
        return id;
    }

    public String getDateReverserd(){
        return dateReverserd;
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

    public void setDateReverserd(String dateReverserd){
        this.dateReverserd = dateReverserd;
    }
    
    public void setIdQuota(Integer idQuota){
        this.idQuota = idQuota;
    }

    public void setIdTransaction(Integer idTransaction){
        this.idTransaction = idTransaction;
    }


}
