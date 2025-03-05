package com.ducthang.accountbankservice.entity;

import lombok.Data;


@Data
public class Bank {
    private String id;
    private String userProfileId;
    private String number;
    private String name;
    private Long balance;
}
