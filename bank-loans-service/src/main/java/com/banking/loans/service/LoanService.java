package com.banking.loans.service;

import com.banking.loans.dto.request.ReqApplyLoan;
import com.banking.loans.dto.response.ResApplyLoan;
import com.banking.loans.dto.response.ResBalance;
import com.banking.loans.dto.response.ResRepay;

public interface LoanService {

    ResApplyLoan applyLoan(ReqApplyLoan loan);

    ResRepay repayLoan(String accountNumber);

    ResBalance pendingDue(String accountNumber);
}
