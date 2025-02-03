package com.ducthang.accountbankservice.controller;

import com.ducthang.accountbankservice.ServiceA;
import com.ducthang.accountbankservice.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private ServiceA serviceA;

    @GetMapping("/internal/users/{userId}")
    public Mono<User> getUsers(String userId) {
        // Gửi Bearer token từ client và nhận kết quả từ ServiceA
        return serviceA.getUsersFromServiceB(userId);
    }
}
