package com.PayRoxxy.api.models;

public class ResponsePaymentModel {
    private HeadResponseModelB head;
    private FeesPaidModel util;

    // Declaración del constructor de clase
    // public ResponsePaymentModel(HeadResponseModelB head, FeesPaidModel util){
    //     this.head = head;
    //     this.util = util;
    // }

    public HeadResponseModelB getHead(){
        return head;
    }
  
    public FeesPaidModel getUtil(){
        return util;
    }

    public void setHead(HeadResponseModelB head){
        this.head = head;
    }
  
    public void setUtil(FeesPaidModel util){
        this.util = util;
    }
    
}
