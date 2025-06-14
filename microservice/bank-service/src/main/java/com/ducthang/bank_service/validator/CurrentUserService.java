package com.ducthang.bank_service.validator;

import com.ducthang.bank_service.dto.UserResponse;
import com.ducthang.bank_service.exception.AppException;
import com.ducthang.bank_service.exception.ErrorCode;
import com.ducthang.bank_service.repository.httpclient.IdentityClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUserService {

    private final IdentityClient identityClient;

    public String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public UserResponse getCurrentUserInfo() {
        var response = identityClient.getMyInfo();
        if (response == null || response.getResult() == null) {
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        return response.getResult();
    }
}
