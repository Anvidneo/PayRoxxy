package com.PayRoxxy.api.controllers;

import com.PayRoxxy.api.models.ConsultPaymentModel;
import com.PayRoxxy.api.models.ResponsePaymentModel;
import com.PayRoxxy.api.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping()
    public ResponsePaymentModel payment(@RequestBody ConsultPaymentModel params) {
        return this.paymentService.payment(params);
    }
}
