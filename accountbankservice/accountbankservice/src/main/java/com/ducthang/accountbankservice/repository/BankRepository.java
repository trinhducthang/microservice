package com.ducthang.accountbankservice.repository;

import com.ducthang.accountbankservice.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank getBanksById(Long id);
    Bank findByNumber(String number);
    Bank findBanksByUserProfileId(String userProfileId);
    boolean existsBanksByUserProfileId(String userProfileId);
    boolean existsBanksByNumber(String number);
}
