package example;

import org.beanio.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class BeanWriterExample {
    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("D:\\projects\\personal\\github\\warehouse\\bean-io\\target\\classes\\mapping2.xml");
        
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
        
        Employee employee3 = new Employee();
        employee3.setFirstName("臺灣");
        employee3.setLastName("繁體中文中華人民共和車");
        employee3.setTitle("1234");
        employee3.setSalary(60000);
        employee3.setHireDate(new Date());



        Charset charset = Charset.forName("BIG5"); // ISO Latin Alphabet No. 1
        //OutputStream ostream = new FileOutputStream("employee2.csv"); // or other OutputStream
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(ostream, charset);

        // use a StreamFactory to create a BeanWriter
//        BeanWriter out = factory.createWriter("employeeFile", new File("employee2.csv"));
        BeanWriter out = factory.createWriter("employeeFile", writer);
        // write an Employee object directly to the BeanWriter
        out.write(new Header());
        out.write(employee);
        out.write(employee1);
        out.write(employee3);
        out.flush();
        out.close();
        byte[] myBytes=ostream.toByteArray();

        System.out.println(myBytes.length);
        try (OutputStream os = new FileOutputStream("d://file.txt") ) {
                        // Starting writing the bytes in it
            os.write(myBytes);
            os.flush();
        }
    }
}