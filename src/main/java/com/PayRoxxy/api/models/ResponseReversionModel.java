package com.PayRoxxy.api.models;

public class ResponseReversionModel {
    private HeadResponseModelB head;
    private UtilResponseModelR util;

    // public ResponseModelB(HeadResponseModelB head, UtilResponseModelR util){
    //     this.head = head;
    //     this.util = util;
    // }

    public HeadResponseModelB getHead(){
        return head;
    }
  
    public UtilResponseModelR getUtil(){
        return util;
    }

    public void setHead(HeadResponseModelB head){
        this.head = head;
    }
  
    public void setUtil(UtilResponseModelR util){
        this.util = util;
    }
}
