package com.ducthang.bank_service.repository;

import com.ducthang.bank_service.entity.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank,String> {
    boolean existsByNickNameOrBankNumber(String nickName, Long bankNumber);
}
