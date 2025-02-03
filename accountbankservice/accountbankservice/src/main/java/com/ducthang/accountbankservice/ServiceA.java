package com.ducthang.accountbankservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ServiceA {

    @Autowired
    private WebClient.Builder webClientBuilder;  // Được inject WebClient.Builder từ @Configuration

    private static final String SERVICE_B_URL = "http://localhost:8081/profile";  // Địa chỉ của ServiceB
    public Mono getUsersFromServiceB(String bearerToken) {
        return webClientBuilder.baseUrl(SERVICE_B_URL)
                .build()  // Dùng build() để tạo WebClient từ Builder
                .get()  // Gọi HTTP GET
                .header("Authorization", "Bearer " + bearerToken)  // Thêm Bearer token vào header
                .retrieve()  // Thực hiện cuộc gọi
                .bodyToMono(ApiResponse.class)  // Phân tích dữ liệu trả về thành ApiResponse
                .map(ApiResponse::getResult);  // Lấy kết quả từ ApiResponse
    }
}
