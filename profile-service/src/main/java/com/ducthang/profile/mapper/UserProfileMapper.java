package com.ducthang.profile.mapper;

import org.mapstruct.Mapper;

import com.ducthang.profile.dto.request.ProfileCreationRequest;
import com.ducthang.profile.dto.response.UserProfileResponse;
import com.ducthang.profile.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
