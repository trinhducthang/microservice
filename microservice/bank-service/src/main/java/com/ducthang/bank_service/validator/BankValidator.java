package com.ducthang.bank_service.validator;

import com.ducthang.bank_service.entity.Bank;
import com.ducthang.bank_service.exception.AppException;
import com.ducthang.bank_service.exception.ErrorCode;
import com.ducthang.bank_service.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankValidator {
    private final BankRepository bankRepository;

    public void validateBankNotExist(Bank bank) {
        if (bankRepository.existsByNickNameOrBankNumber(bank.getNickName(), bank.getBankNumber())) {
            throw new AppException(ErrorCode.BANK_ACCOUNT_EXISTED);
        }
    }
}
