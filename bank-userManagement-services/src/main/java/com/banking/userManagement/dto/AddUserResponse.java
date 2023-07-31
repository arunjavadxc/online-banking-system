package com.banking.usermanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddUserResponse {

    private String accountNumber;
    private String name;
}
