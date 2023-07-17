package com.banking.userManagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String name;
    private String emailId;
    private String number;
    private String address;
}
