package com.ducthang.bank_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "banks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @Id
    private String id;

    private String userId;
    private long bankNumber;
    private String nickName;
    private BigDecimal amount;
}
