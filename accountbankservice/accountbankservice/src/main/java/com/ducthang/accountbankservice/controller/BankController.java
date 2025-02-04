package com.ducthang.accountbankservice.controller;

import com.ducthang.accountbankservice.dto.request.ProfileCreationRequest;
import com.ducthang.accountbankservice.dto.response.ApiResponse;
import com.ducthang.accountbankservice.UserProfile;
import com.ducthang.accountbankservice.httpclient.ProfileClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final WebClient webClient;

    private final ProfileClient profileClient;

    // Constructor nhận WebClient.Builder để cấu hình WebClient
    public BankController(WebClient.Builder webClientBuilder, ProfileClient profileClient) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build(); // URL của dịch vụ bên ngoài
        this.profileClient = profileClient;
    }

    // Định nghĩa API endpoint của microservice của bạn
    @PutMapping("/{id}")
    public Mono<ApiResponse<UserProfile>> getUserProfile(@PathVariable String id, @RequestParam String bank) {
        try{
            return webClient.get()
                    .uri("/profile/internal/users/{id}", id) // Thay thế {id} bằng ID người dùng
                    .retrieve()  // Thực hiện GET request
                    .onStatus(status -> status.value() == 404, clientResponse -> {
                        // Nếu status là 404, trả về ApiResponse với thông báo không tồn tại
                        return null;
                    })
                    .bodyToMono(new ParameterizedTypeReference<ApiResponse<UserProfile>>() {})  // Chỉ định rõ kiểu dữ liệu
                    .flatMap(response -> {
                        // Kiểm tra phản hồi từ API bên ngoài và trả về ApiResponse với đúng kiểu
                        if (response.getCode() == 1000 && response.getResult() != null) {
                            // Trả về ApiResponse<UserProfile>
                            var profile = new UserProfile();
                            profile = response.getResult();

                            ProfileCreationRequest request = new ProfileCreationRequest();
                            request.setLastName(profile.getLastName());
                            request.setFirstName(profile.getFirstName());
                            request.setBanks(bank);

                            profileClient.createProfile(request,id);


                            return Mono.just(response);
                        }
                        else if(response.getCode() == 1005){
                            return Mono.just(response);
                        }
                        else {
                            // Nếu không có kết quả, trả về lỗi
                            return Mono.just(new ApiResponse<>(4000, "User not found"));
                        }
                    });
        }
        catch (Exception e){
            return Mono.just(new ApiResponse<>(4000, "User not found"));
        }
    }

}
