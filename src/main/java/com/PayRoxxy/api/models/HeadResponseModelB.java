package com.PayRoxxy.api.models;

public class HeadResponseModelB {
    // Variables de instancia
    private String codError;
    private String description;

    // Declaración del constructor de clase
    // public HeadResponseModelB(String CodError, String Description){
    //     this.codError    = CodError;
    //     this.description = Description;
    // }

    public String getCodError() {
        return codError;
    }
    
    public String getDescription(){
        return description;
    }

    public void setCodError(String CodError){
        this.codError = CodError;
    }
    
    public void setDescription(String Description){
        this.description = Description;
    }

}
