package com.PayRoxxy.api.models;

public class UtilConsultModelB {
    // Variables de instancia
    private String codService;
    private String codSearch;
    
    // Declaración del constructor de clase
    public UtilConsultModelB(String codService, String codSearch){
        this.codService = codService;
        this.codSearch  = codSearch;
    }

    public String getCodService() {
        return codService;
    }
  
    public String getCodSearch(){
        return codSearch;
    }
}
