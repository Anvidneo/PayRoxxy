package com.PayRoxxy.api.controllers;

import com.PayRoxxy.api.models.ConsultReversionModel;
import com.PayRoxxy.api.models.ResponseReversionModel;
import com.PayRoxxy.api.services.ReversionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reversion")
public class ReversionController {
    @Autowired
    ReversionService reversionService;

    @PostMapping()
    public ResponseReversionModel reversion(@RequestBody ConsultReversionModel params) {
        return this.reversionService.reversion(params);
    }
}