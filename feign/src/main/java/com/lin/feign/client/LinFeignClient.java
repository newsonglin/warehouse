package com.lin.feign.client;

import com.lin.feign.config.LinFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@FeignClient(url = "https://efolder-mli-dev01.dev.aws06.mlic.cloud", name = "linFeignClient", configuration = LinFeignConfig.class)
public interface LinFeignClient {

    @RequestMapping(method= RequestMethod.POST,
            headers = {"Content-Type: multipart/form-data"},
            value= "/api/efolder/documents/v1/documents/{docId}/content")
    String uploadFile(@PathVariable String docId, File file);
}
