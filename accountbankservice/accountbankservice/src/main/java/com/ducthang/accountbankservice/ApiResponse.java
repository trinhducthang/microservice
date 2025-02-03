package com.ducthang.accountbankservice;

import java.util.List;

public class ApiResponse<T> {
    private int code;
    private T result;  // List chứa các đối tượng UserResponse

    // Getter và Setter cho `code` và `result`
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

