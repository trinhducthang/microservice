package com.ducthang.bank_service.service;

import com.ducthang.bank_service.entity.Bank;
import org.springframework.stereotype.Service;

@Service
public interface BankServiceItf {
    Bank getBank();
    Bank createBank(Bank bank);
    Bank updateBank(Bank bank);
    Bank deleteBank(Bank bank);
}
