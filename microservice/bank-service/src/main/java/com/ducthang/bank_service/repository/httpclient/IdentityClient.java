package com.ducthang.bank_service.repository.httpclient;

import com.ducthang.bank_service.configuration.AuthenticationRequestInterceptor;
import com.ducthang.bank_service.dto.ApiResponse;
import com.ducthang.bank_service.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "identity-service", url = "http://localhost:8080/identity/users",
    configuration = { AuthenticationRequestInterceptor.class })
public interface IdentityClient {
    @GetMapping("/my-info")
    ApiResponse<UserResponse> getMyInfo();
}
