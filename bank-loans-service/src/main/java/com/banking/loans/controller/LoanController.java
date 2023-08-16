package com.banking.loans.controller;

import com.banking.loans.dto.request.ReqApplyLoan;
import com.banking.loans.dto.response.ResApplyLoan;
import com.banking.loans.dto.response.ResBalance;
import com.banking.loans.dto.response.ResRepay;
import com.banking.loans.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.banking.loans.utils.Constants.API_PREFIX_V1;

@RestController
@RequestMapping(path =  API_PREFIX_V1)
public class LoanController {
    @Autowired
    private LoanService service;

    @PostMapping("/loan/apply")
    public ResponseEntity applyLoan(@RequestBody ReqApplyLoan loan){
        ResApplyLoan response =service.applyLoan(loan);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/loan/pay")
    public ResponseEntity repayLoan(@RequestBody Map<String,String> accountNumber)
    {
        ResRepay response= service.repayLoan(accountNumber.get("accountNumber"));
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/loan/balance/{accountNumber}")
    public ResponseEntity balance(@PathVariable("accountNumber") String accountNumber){
        ResBalance amount = service.pendingDue(accountNumber);
        return new ResponseEntity(amount,HttpStatus.OK);

    }
}
