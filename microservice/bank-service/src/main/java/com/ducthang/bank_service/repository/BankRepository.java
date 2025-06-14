package com.ducthang.bank_service.repository;

import com.ducthang.bank_service.entity.Bank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BankRepository extends MongoRepository<Bank,String> {
    boolean existsByNickNameOrBankNumber(String nickName, Long bankNumber);

    Optional<Bank> findByUserId(String userId);

    Optional<Bank> findByBankNumber(long bankNumber);
}
