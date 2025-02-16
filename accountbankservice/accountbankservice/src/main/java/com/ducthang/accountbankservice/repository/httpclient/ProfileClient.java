package com.ducthang.accountbankservice.repository.httpclient;

import com.ducthang.accountbankservice.dto.request.ProfileCreationRequest;
import com.ducthang.accountbankservice.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "profile-service", url = "http://localhost:8081/profile")
public interface ProfileClient {
    @PutMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request, @PathVariable String id);


}
