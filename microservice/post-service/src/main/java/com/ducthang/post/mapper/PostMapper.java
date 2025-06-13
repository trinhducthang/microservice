package com.ducthang.post.mapper;

import com.ducthang.post.dto.response.PostResponse;
import com.ducthang.post.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse toPostResponse(Post post);
}
