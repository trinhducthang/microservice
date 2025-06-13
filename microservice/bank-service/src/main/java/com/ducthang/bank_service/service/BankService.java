package com.ducthang.bank_service.service;

import com.ducthang.bank_service.dto.UserResponse;
import com.ducthang.bank_service.entity.Bank;
import com.ducthang.bank_service.exception.AppException;
import com.ducthang.bank_service.exception.ErrorCode;
import com.ducthang.bank_service.repository.BankRepository;
import com.ducthang.bank_service.repository.httpclient.IdentityClient;
import com.ducthang.bank_service.validator.BankValidator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BankService implements BankServiceItf {

     BankRepository bankRepository;
     IdentityClient identityClient;
     BankValidator bankValidator;

    @Override
    public Bank getBank() {

        return null;
    }

    @Override
    public Bank createBank(Bank bank) {
        bankValidator.validateBankNotExist(bank);

        String userId = getCurrentUserId();

        UserResponse user = getCurrentUserInfo();

        bank.setUserId(userId);

        return bankRepository.save(bank);
    }


    private String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private UserResponse getCurrentUserInfo() {
        var response = identityClient.getMyInfo();
        if (response == null || response.getResult() == null) {
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        return response.getResult();
    }

    @Override
    public Bank updateBank(Bank bank) {
        return null;
    }

    @Override
    public Bank deleteBank(Bank bank) {
        return null;
    }
}
