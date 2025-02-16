package com.ducthang.profile.controller;

import java.util.List;

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
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/users")
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createProfile(request);
    }

    @GetMapping("/users/{profileId}")
    ApiResponse<UserProfileResponse> getProfile(@PathVariable String profileId) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getProfile(profileId))
                .build();
    }

    @PutMapping("/users/{id}")
    ApiResponse<UserProfileResponse> updateUser(@RequestBody ProfileCreationRequest request, @PathVariable String id) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.updateUserById(request, id))
                .build();
    }

    @GetMapping("/users")
    ApiResponse<List<UserProfileResponse>> getAllProfiles() {
        return ApiResponse.<List<UserProfileResponse>>builder()
                .result(userProfileService.getAllProfiles())
                .build();
    }

    @GetMapping("/users/my-profile")
    ApiResponse<UserProfileResponse> getMyProfile() {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getMyProfile())
                .build();
    }
}
