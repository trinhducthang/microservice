package com.ducthang.bank_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1000, "Uncategorized error", HttpStatus.BAD_REQUEST),
    BANK_NOT_FOUND(1001, "Bank not found", HttpStatus.NOT_FOUND),
    BANK_ACCOUNT_EXISTED(1002, "Bank account already exists", HttpStatus.BAD_REQUEST),
    INVALID_BANK_USERNAME(1003, "Username is invalid or empty", HttpStatus.BAD_REQUEST),
    INVALID_BANK_NUMBER(1004, "Bank account number must be positive", HttpStatus.BAD_REQUEST),
    INVALID_BANK_NICKNAME(1005, "Nickname must not be empty", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1006, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1007, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1008, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1009, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
