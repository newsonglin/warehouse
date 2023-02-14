package com.lin.feign;

import com.lin.feign.client.LinFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication(scanBasePackages = "com.lin.feign")
@EnableFeignClients
public class LinApplication {

//   // constructor
//   private LinFeignClient linFeignClient;
//
//    @GetMapping("/upload/")
//    public Object upload( @RequestParam("docId") String docId) {
//        return linFeignClient.uploadFile();
//    }

    public static void main(String[] args) {
        SpringApplication.run(LinApplication.class, args);
    }
}
