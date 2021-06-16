package com.PayRoxxy.api.models;

public class ResponseModelB {
    private HeadResponseModelB head;
    private UtilResponseModelB util;

    // public ResponseModelB(HeadResponseModelB head, UtilResponseModelB util){
    //     this.head = head;
    //     this.util = util;
    // }

    public HeadResponseModelB getHead(){
        return head;
    }
  
    public UtilResponseModelB getUtil(){
        return util;
    }

    public void setHead(HeadResponseModelB head){
        this.head = head;
    }
  
    public void setUtil(UtilResponseModelB util){
        this.util = util;
    }
}
