package com.banking.transaction.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.transaction.dto.BillRequest;
import com.banking.transaction.model.BillingModel;
import com.banking.transaction.service.BillingService;
import com.banking.transaction.utils.Constants;

@RequestMapping(path = Constants.API_PREFIX_V1)
@RestController
public class BillingController {
    @Autowired
    private BillingService billingService;

    @PostMapping("/bill/pay")
    public ResponseEntity payBill(@RequestBody BillRequest request){
        String response = billingService.PayBill(request);
        Map<String,String> resp = new HashMap<>();
        resp.put("Msg", response);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @PostMapping("/bill/add")
    public ResponseEntity addBill(@RequestBody BillingModel request)
    {
        BillingModel response = billingService.addBill(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
