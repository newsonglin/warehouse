package com.lin.beanio;

/**
 * BeanReaderExample in lin project.
 *
 * @author Songlin.Li <songlin.li@eisgroup.com>
 * @since 2018/9/21
 */
import org.beanio.*;
import java.io.*;

public class BeanReaderExample {
    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("F:\\github\\projects\\PhotoMaster\\src\\mapping.xml");

        // use a StreamFactory to create a BeanReader
        BeanReader in = factory.createReader("employeeFile", new File("F:\\github\\projects\\PhotoMaster\\src\\employee.csv"));
        Object  obj;
        while ((obj =  in.read()) != null) {
            if(obj instanceof Header){
                System.out.println("Header");

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