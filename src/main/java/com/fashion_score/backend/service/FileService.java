package com.fashion_score.backend.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    @Value("${spring.file.savePath}")
    private String savePath;

    public boolean uploadFile(MultipartFile file){
        System.out.println("start save!!!!!");
        String fileName = "";
        if (file.getOriginalFilename() != null) {
            fileName = FilenameUtils.getName(file.getOriginalFilename());
        }
        Path fileNameAndPath = Paths.get(savePath, fileName);
        try {
            Files.write(fileNameAndPath, file.getBytes());
            System.out.println("save over!!!!");
            return true;
        } catch (IOException e) {
            System.out.println("save over!!!!");
            e.printStackTrace();
            return false;
        }
    }

}
