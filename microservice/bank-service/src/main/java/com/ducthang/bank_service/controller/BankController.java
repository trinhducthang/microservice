package com.ducthang.bank_service.controller;

import com.ducthang.bank_service.dto.ApiResponse;
import com.ducthang.bank_service.entity.Bank;
import com.ducthang.bank_service.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping
    public Bank getBank() {
        return bankService.getBank();
    }

    @PostMapping("/registration")
    public ApiResponse<Bank> createBank(@RequestBody Bank bank) {
        return ApiResponse.<Bank>builder()
                .result(bankService.createBank(bank))
                .build();
    }
}
