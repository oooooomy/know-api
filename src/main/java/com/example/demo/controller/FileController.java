package com.example.demo.controller;

import com.example.demo.annotation.DisableBaseResponse;
import com.example.demo.model.entity.Image;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Resource
    private ImageService imageService;

    @Value("${videoSavePath}")
    private String savePath;

    /**
     * 上传图片
     *
     * @param file 文件
     * @return 文件id
     * @throws Exception .
     */
    @PostMapping("/image")
    @DisableBaseResponse
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) throw new Exception("File cannot be empty");
        return imageService.save(file);
    }

    /**
     * 获取图片 给前端展示
     *
     * @param id       文件id
     * @param response .
     * @throws Exception .
     */
    @GetMapping("/image/{id}")
    public void getImage(@PathVariable String id, HttpServletResponse response) throws Exception {
        Image image = imageService.findById(id);
        if (image == null) return;
        byte[] data = image.getData();
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream outputStream = response.getOutputStream();
        InputStream in = new ByteArrayInputStream(data);
        int len;
        byte[] buf = new byte[1024];
        while ((len = in.read(buf, 0, 1024)) != -1) {
            outputStream.write(buf, 0, len);
        }
        outputStream.close();
    }

    @PostMapping("/video")
    @DisableBaseResponse
    public String uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        String id = UUID.randomUUID().toString();
        file.transferTo(new File(savePath + "/" + id + ".mp4"));
        return id;
    }

    @GetMapping("/video/{id}")
    @DisableBaseResponse
    public void getVideo(@PathVariable String id, HttpServletResponse response) throws IOException {
        String path = savePath + "/" + id + ".mp4";
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] data = new byte[fileInputStream.available()];
        int i = fileInputStream.read(data);
        response.setContentType("video/mp4");
        response.setHeader("Content-Disposition", "attachment; filename=" + id + ".mp4");
        response.setContentLength(data.length);
        OutputStream os = response.getOutputStream();
        os.write(data);
        os.flush();
        os.close();
        fileInputStream.close();
    }

}
