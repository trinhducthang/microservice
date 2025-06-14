package com.ducthang.bank_service.controller;

import com.ducthang.bank_service.dto.ApiResponse;
import com.ducthang.bank_service.entity.Bank;
import com.ducthang.bank_service.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;


    @PostMapping("/registration")
    public ApiResponse<Bank> createBank(@RequestBody Bank bank) {
        return ApiResponse.<Bank>builder()
                .result(bankService.createBank(bank))
                .build();
    }

    @GetMapping("")
    public ApiResponse<Bank> getBanks() {
        return ApiResponse.<Bank>builder()
                .result(bankService.getBank())
                .build();
    }

    @DeleteMapping("")
    public ApiResponse<Boolean> deleteBank() {
        return ApiResponse.<Boolean>builder()
                .result(bankService.deleteBank())
                .build();
    }

    @PutMapping("/{bankNumber}")
    public ApiResponse<Bank> updateBank(@PathVariable("bankNumber") Long bankNumber, @RequestBody BigDecimal amount) {
        return ApiResponse.<Bank>builder()
                .result(bankService.updateAmount(bankNumber, amount))
                .build();
    }
}
