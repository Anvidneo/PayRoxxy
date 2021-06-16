package com.PayRoxxy.api.models;

public class ConsultReversionModel {
    // Variables de instancia
    private HeadConsultModel head;
    private UtilConsultModelR util;
 
    // Declaración del constructor de clase
    public ConsultReversionModel(HeadConsultModel head, UtilConsultModelR util){
        this.head = head;
        this.util = util;
    }

    public HeadConsultModel getHead(){
        return head;
    }
  
    public UtilConsultModelR getUtil(){
        return util;
    }
}
