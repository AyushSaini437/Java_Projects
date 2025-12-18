package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UrlService;

@RestController
public class AccessUrlController {
    @Autowired
    private UrlService urlService;

    @GetMapping("/r/{code}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String code) {
        String originalUrl = urlService.getOriginalUrlByCode(code);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", originalUrl);
        return new ResponseEntity<>(headers, HttpStatus.FOUND); // 302 redirect
    }

}