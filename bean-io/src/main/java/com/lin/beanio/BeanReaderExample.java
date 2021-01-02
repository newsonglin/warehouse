package com.lin.beanio;

/**
 * BeanReaderExample in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2018/9/21
 */

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import java.io.File;

public class BeanReaderExample {
    public static void main(String[] args) throws Exception {


        String myTargetClassPath=BeanReaderExample.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load(myTargetClassPath+"mapping.xml");

        System.out.println();
        // use a StreamFactory to create a BeanReader
        BeanReader in = factory.createReader("employeeFile", new File(myTargetClassPath+"employee.csv"));
        Object  obj;
        while ((obj =  in.read()) != null) {
            if(obj instanceof Header){
                System.out.println("Header");
                System.out.println(((Header)obj).getFileDate());

            }else if (obj instanceof Employee){
                System.out.println("Body");

            }else if (obj instanceof Trailer){
                System.out.println("Trailer");


            }
            // process the employee...
        }
        in.close();
    }
}