package com.lin.feign;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LinApplication.class)
public class LinApplicationTests {

    @Autowired
    LinApplication.Producer producer;

    @Test
    public void createEvent() throws InterruptedException {

        producer.create("foo");

        producer.asyncMethod();


        // A chance to see the logging messages before the JVM exists.
        Thread.sleep(12000);

    }
}
