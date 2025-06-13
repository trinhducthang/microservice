package com.ducthang.identity.mapper;

import org.mapstruct.Mapper;

import com.ducthang.identity.dto.request.ProfileCreationRequest;
import com.ducthang.identity.dto.request.UserCreationRequest;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
