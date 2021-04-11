package com.example.demo.service.impl;

import com.example.demo.mapper.ImageMapper;
import com.example.demo.model.entity.Image;
import com.example.demo.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public String save(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        byte[] data = new byte[(int) file.getSize()];
        int i = inputStream.read(data);
        String id = UUID.randomUUID().toString();
        imageMapper.insert(new Image(id, data));
        return id;
    }

    @Override
    public Image findById(String id) {
        return imageMapper.selectById(id);
    }

}
