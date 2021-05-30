package com.ngnam.controllers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(path="/api")
public class APIController {

    // API lấy hình ảnh từ server trả về cho giao diện
    // Lấy ảnh từ file /uploads/images/mau_san_pham (mẫu sản phẩm)
    @GetMapping(path="/getimages/{photo}")
    public ResponseEntity<ByteArrayResource> getImage(
            @PathVariable("photo") String photo) {
        // Lấy định dạng của ảnh
        String[] typeOfImage = photo.split("\\.");
        String contentType = "image/" + typeOfImage[1];

        if (!photo.isEmpty() || photo != null) {
            try {
                Path fileName = Paths.get("uploads/images/mau_san_pham/", photo);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);

                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(byteArrayResource);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
