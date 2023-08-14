package com.banking.loans.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResRepay {
    private double pendingDue;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date nextPaymentDate;
}
