package com.ducthang.accountbankservice.service;

import com.ducthang.accountbankservice.entity.Bank;
import com.ducthang.accountbankservice.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountBankService {

    private final BankRepository bankRepository;

    public Bank getBank(Long id) {
        return bankRepository.getBanksById(id);
    }

    public Bank createBank(Bank bank, String userProfileId) {
        if(bankRepository.existsBanksByNumber(bank.getNumber()) && bankRepository.existsBanksByUserProfileId(userProfileId)) {
            throw new RuntimeException("Bank already exists");

        }
        bank.setUserProfileId(userProfileId);
        bank.setBalance(0L);
        bank.setName("MBBank");
        return bankRepository.save(bank);
    }

    public Bank getBankByUserProfileId(String userProfileId) {
        return bankRepository.findBanksByUserProfileId(userProfileId);
    }
}
