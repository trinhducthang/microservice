package com.ducthang.profile.mapper;

import com.ducthang.profile.dto.request.UpdateProfileRequest;
import org.mapstruct.Mapper;

import com.ducthang.profile.dto.request.ProfileCreationRequest;
import com.ducthang.profile.dto.response.UserProfileResponse;
import com.ducthang.profile.entity.UserProfile;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfile entity);

    void update(@MappingTarget UserProfile entity, UpdateProfileRequest request);
}
