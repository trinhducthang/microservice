package com.ducthang.file.dto.response;

import org.springframework.core.io.Resource;

public record FileData(String contentType, Resource resource) {}
