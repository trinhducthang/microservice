package com.ducthang.identity.mapper;

import org.mapstruct.Mapper;

import com.ducthang.identity.dto.request.PermissionRequest;
import com.ducthang.identity.dto.response.PermissionResponse;
import com.ducthang.identity.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
