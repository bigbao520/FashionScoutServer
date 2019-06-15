package com.fashion_score.backend.controller;

import com.fashion_score.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/upload")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> uploadReport(@RequestParam("file") MultipartFile file) {
        System.out.println("Controller start！");
        Map<String,String> status=new HashMap<>();
        if (fileService.uploadFile(file)) {
            System.out.println("upload success!");
            status.put("status","true");
        } else {
            System.out.println("upload failed!");
            status.put("status","false");
        }
        return status;
    }

    @GetMapping
    public String testConnect() {
        return "hello!";
    }

    @PostMapping(value = "/string")
    public void testConnect(@RequestBody Map<String,String> output) {
        System.out.println(output.get("string"));
    }
}
