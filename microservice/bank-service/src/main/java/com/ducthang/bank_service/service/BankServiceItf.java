package com.ducthang.bank_service.service;

import com.ducthang.bank_service.entity.Bank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface BankServiceItf {
    Bank getBank();
    Bank createBank(Bank bank);
    Bank updateBank(String bankId);
    boolean deleteBank();

    Bank updateAmount(Long bankNumber, BigDecimal amount);
}
