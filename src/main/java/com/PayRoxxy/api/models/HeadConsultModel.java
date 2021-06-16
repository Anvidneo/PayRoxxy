package com.PayRoxxy.api.models;

public class HeadConsultModel {
    // Variables de instancia
    private String entity;
    private String user;
    private String password;
    
    // Declaración del constructor de clase
    public HeadConsultModel(String entity, String user, String password){
        this.entity     = entity;
        this.user       = user;
        this.password   = password;
    }

    public String getEntity() {
        return entity;
    }
  
    public String getUser(){
        return user;
    }
    
    public String getPassword(){
        return password;
    }

}
