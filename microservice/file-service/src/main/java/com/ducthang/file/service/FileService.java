package com.ducthang.file.service;

import com.ducthang.file.dto.response.FileData;
import com.ducthang.file.dto.response.FileResponse;
import com.ducthang.file.exception.AppException;
import com.ducthang.file.exception.ErrorCode;
import com.ducthang.file.mapper.FileMgmtMapper;
import com.ducthang.file.repository.FileMgmtRepository;
import com.ducthang.file.repository.FileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileService {
    FileRepository fileRepository;
    FileMgmtRepository fileMgmtRepository;

    FileMgmtMapper fileMgmtMapper;

    public FileResponse uploadFile(MultipartFile file) throws IOException {
        // Store file
        var fileInfo = fileRepository.store(file);

        // Create file management info
        var fileMgmt = fileMgmtMapper.toFileMgmt(fileInfo);
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        fileMgmt.setOwnerId(userId);

        fileMgmt = fileMgmtRepository.save(fileMgmt);

        return FileResponse.builder()
                .originalFileName(file.getOriginalFilename())
                .url(fileInfo.getUrl())
                .build();
    }

    public FileData download(String fileName) throws IOException {
        var fileMgmt = fileMgmtRepository.findById(fileName).orElseThrow(
                () -> new AppException(ErrorCode.FILE_NOT_FOUND));

        var resource = fileRepository.read(fileMgmt);

        return new FileData(fileMgmt.getContentType(), resource);
    }
}
