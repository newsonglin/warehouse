package com.lin.io;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BeanWriteExample {
    public static void main(String[] args) throws Exception {

        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.loadResource("mapping2.xml");

        List<Employee> employees = new ArrayList<Employee>();

        Employee employee = new Employee();
        employee.setFirstName("Jennifer");
        employee.setLastName("Jones");
        employee.setTitle("Marketing");
        employee.setSalary(60000);
        employee.setHireDate(new Date());

        Employee employee1 = new Employee();
        employee1.setFirstName("JACk");
        employee1.setLastName("Jones");
        employee1.setTitle("Tele");
        employee1.setSalary(60000);
        employee1.setHireDate(new Date());

        employees.add(employee);
        employees.add(employee1);

        // use a StreamFactory to create a BeanWriter
        BeanWriter out = factory.createWriter("employeeFile", new File("employee_out.csv"));
        Header header = new Header();
        header.setRecordType("hh");
        header.setFileDate(new Date());
        out.write(header);
//        out.write(header);

        // write an Employee object directly to the BeanWriter
//        for(Employee e: employees){
//            out.write(e);
//        }
        //out.write(employee1);
        out.flush();
        out.close();
    }
}
