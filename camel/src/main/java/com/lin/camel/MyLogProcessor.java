package com.lin.camel;


import jxl.Sheet;
import jxl.Workbook;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.component.file.GenericFileConverter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MyLogProcessor in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2019/6/12
 */
public class MyLogProcessor implements Processor {
    private List<String> sheetsToLoad;

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("size is #" +exchange.getProperty("CamelBatchSize"));
        exchange.getIn().getHeaders().put("size", exchange.getProperty("CamelBatchSize"));
//        System.out.println("Processing message with body    "+exchange.getIn().getBody(String.class));
        System.out.println("Processing message file name=="+ exchange.getIn().getHeader(Exchange.FILE_NAME));
    }
}
