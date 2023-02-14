package com.lin.feign.controller;

import com.lin.feign.service.LinService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class LinController {

    private final LinService service;


    public LinController(LinService service) {
        this.service = service;
    }

    @PostMapping("/{docId}")
    @ResponseStatus(HttpStatus.OK)
    public void uploadFile(@PathVariable String docId) {
        service.doUpload(docId);
    }
}
