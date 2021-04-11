package com.example.demo.service;

import com.example.demo.model.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    String save(MultipartFile file) throws IOException;

    Image findById(String id);

}
