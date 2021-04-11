package com.example.demo.controller;

import com.example.demo.mapper.VideoMapper;
import com.example.demo.model.entity.Video;
import com.example.demo.service.VideoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {

    @Resource
    private VideoService videoService;

    @GetMapping("")
    public List<Video> findAll() {
        return videoService.findAll();
    }

    @PostMapping("")
    public void save(@RequestBody Video video) {
        videoService.save(video);
    }

}
