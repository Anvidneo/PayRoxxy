package com.PayRoxxy.api.models;

public class ConsultPaymentModel {
    // Variables de instancia
    private HeadConsultModel head;
    private UtilConsultModelP util;
 
    // Declaración del constructor de clase
    public ConsultPaymentModel(HeadConsultModel head, UtilConsultModelP util){
        this.head = head;
        this.util = util;
    }

    public HeadConsultModel getHead(){
        return head;
    }
  
    public UtilConsultModelP getUtil(){
        return util;
    }

}
