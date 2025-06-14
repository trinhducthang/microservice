package com.ducthang.bank_service.service;

import com.ducthang.bank_service.dto.UserResponse;
import com.ducthang.bank_service.entity.Bank;
import com.ducthang.bank_service.exception.AppException;
import com.ducthang.bank_service.exception.ErrorCode;
import com.ducthang.bank_service.repository.BankRepository;
import com.ducthang.bank_service.validator.BankValidator;
import com.ducthang.bank_service.validator.CurrentUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BankService implements BankServiceItf {

     BankRepository bankRepository;
     BankValidator bankValidator;
     CurrentUserService currentUserService;

    @Override
    public Bank getBank() {
        UserResponse user = currentUserService.getCurrentUserInfo();
        String userId = user.getId();

        return bankRepository.findByUserId(userId).orElseThrow(
                () -> new AppException(ErrorCode.BANK_NOT_FOUND)
        );
    }

    @Override
    public Bank createBank(Bank bank) {

        //check bank exist
        bankValidator.validateBankNotExist(bank);

        //check user id from token
        UserResponse user = currentUserService.getCurrentUserInfo();
        String userId = user.getId();

        bank.setAmount(BigDecimal.valueOf(0.00));
        bank.setUserId(userId);
        return bankRepository.save(bank);
    }


    @Override
    public Bank updateBank(String bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(
                () -> new AppException(ErrorCode.BANK_NOT_FOUND)
        );

        return null;
    }

    @Override
    public boolean deleteBank() {
        UserResponse user = currentUserService.getCurrentUserInfo();
        String userId = user.getId();


        Bank bank = bankRepository.findByUserId(userId).orElseThrow(
                () -> new AppException(ErrorCode.BANK_NOT_FOUND)
        );

        bankRepository.delete(bank);

        return true;
    }

    @Override
    public Bank updateAmount(Long bankNumber, BigDecimal amount) {

        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Bank bank = bankRepository.findByBankNumber(bankNumber)
                .orElseThrow(() -> new AppException(ErrorCode.BANK_NOT_FOUND));

        if (!bank.getUserId().equals(userId)) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        bank.setAmount(amount);

        return bankRepository.save(bank);
    }
}
