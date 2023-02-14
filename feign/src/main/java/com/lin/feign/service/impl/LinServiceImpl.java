package com.lin.feign.service.impl;

import com.lin.feign.client.LinFeignClient;
import com.lin.feign.service.LinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Slf4j
@RequiredArgsConstructor
public class LinServiceImpl implements LinService {

    private final LinFeignClient linFeignClient;

    @Override
    public void doUpload(String docId) {
        log.info("start uploading with feign client");
        File file = new File("d:\\a.txt");
        linFeignClient.uploadFile(docId,file);
        log.info("finish uploading with feign client");
    }
}
