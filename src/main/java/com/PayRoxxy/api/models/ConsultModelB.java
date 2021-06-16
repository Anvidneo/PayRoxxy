package com.PayRoxxy.api.models;

public class ConsultModelB {
    // Variables de instancia
    private HeadConsultModel head;
    private UtilConsultModelB util;
 
    // Declaración del constructor de clase
    public ConsultModelB(HeadConsultModel head, UtilConsultModelB util){
        this.head = head;
        this.util = util;
    }

    public HeadConsultModel getHead(){
        return head;
    }
  
    public UtilConsultModelB getUtil(){
        return util;
    }

}
