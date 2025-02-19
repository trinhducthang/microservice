package com.ducthang.accountbankservice.service;

import com.ducthang.accountbankservice.entity.Transfer;
import com.ducthang.accountbankservice.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;

    public void Transfer(Transfer transfer) {

    }
}
