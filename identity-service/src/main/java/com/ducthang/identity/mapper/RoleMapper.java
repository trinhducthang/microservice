package com.ducthang.identity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ducthang.identity.dto.request.RoleRequest;
import com.ducthang.identity.dto.response.RoleResponse;
import com.ducthang.identity.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
