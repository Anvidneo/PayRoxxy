package com.PayRoxxy.api.controllers;

import com.PayRoxxy.api.models.ConsultModelB;
import com.PayRoxxy.api.models.ResponseModelB;
import com.PayRoxxy.api.services.ConsultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/consult")
public class ConsultController {
    @Autowired
    ConsultService consultService;
    
    @PostMapping()
    public ResponseModelB consultByCliente(@RequestBody ConsultModelB params) {
        return this.consultService.consultByCliente(params);
    }
}
