package com.ducthang.profile.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ducthang.profile.dto.ApiResponse;
import com.ducthang.profile.dto.request.ProfileCreationRequest;
import com.ducthang.profile.dto.response.UserProfileResponse;
import com.ducthang.profile.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/internal/users")
    ApiResponse<UserProfileResponse> createProfile(@RequestBody ProfileCreationRequest request) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.createProfile(request))
                .build();
    }

    @PutMapping("/internal/users/{id}")
    ApiResponse<UserProfileResponse> updateUser(@RequestBody ProfileCreationRequest request, @PathVariable String id) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.updateUser(request, id))
                .build();
    }

    @GetMapping("/internal/users/{userId}")
    public ResponseEntity<ApiResponse<UserProfileResponse>> getProfile(@PathVariable String userId) {
        ApiResponse<UserProfileResponse> response = ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getByUserId(userId))
                .build();

        return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(response);
    }
}
