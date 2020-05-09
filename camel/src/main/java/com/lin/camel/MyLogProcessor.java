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
//        System.out.println("Processing message with body"+exchange.getIn().getBody(String.class));

        GenericFile file= exchange.getIn().getBody(GenericFile.class);
        InputStream stream=GenericFileConverter.genericFileToInputStream(file,exchange);

        load(new File(file.getAbsoluteFilePath()));

        System.out.println("Processing message file name=="+ exchange.getIn().getHeader(Exchange.FILE_NAME));
    }




    public void load(File file ) {

//        InputStream inputStream = null;
        try {
//            System.out.println("Loading data from '{}'"+ resource.getDescription());

//            inputStream = resource.getInputStream();
            Workbook workbook = Workbook.getWorkbook(file);
//            inputStream.close();
            Sheet[] sheets = workbook.getSheets();
            System.out.println("Sheets to load: {}"+sheetsToLoad);
            for (Sheet sheet : sheets) {
                if (sheetsToLoad != null && !sheetsToLoad.contains(sheet.getName())){
                    System.out.println("Skipping sheet '{}'"+sheet.getName());
                    continue;
                }

                System.out.println("Loading data from sheet '{}'"+sheet.getName());

                if (sheet.getRows() == 0) {
                    continue;
                }
                System.out.println("processing sheet.................");
//                processSheet(sheet);

            } // for (Sheet sheet : sheets)

            // Finished - close the workbook and free up memory
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException("Failed to load data from: " + resource.getDescription(),                    e);
        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                }
//            }
        }
    }


}
