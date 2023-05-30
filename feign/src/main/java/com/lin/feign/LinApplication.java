package com.lin.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = "com.lin.feign")
@EnableFeignClients
@EnableAsync
public class LinApplication {

    //   // constructor
//   private LinFeignClient linFeignClient;
//
//    @GetMapping("/upload/")
//    public Object upload( @RequestParam("docId") String docId) {
//        return linFeignClient.uploadFile();
//    }
    static final Logger logger = LoggerFactory.getLogger(LinApplication.class);

    @Bean
    TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }


    static class MedicalRecordUpdatedEvent {

        private String id;

        public MedicalRecordUpdatedEvent(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "MedicalRecordUpdatedEvent{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

    @Component
    static class Receiver {

        @EventListener
        void handleSync(MedicalRecordUpdatedEvent event) {
            logger.info("sync ---- thread '{}' handling '{}' event", Thread.currentThread(), event);
        }

        @Async
        @EventListener
        void handleAsync(MedicalRecordUpdatedEvent event) {
            logger.info("Async ----thread '{}' handling '{}' event", Thread.currentThread(), event);
        }

    }

    @Component
    static class Producer {

        private final ApplicationEventPublisher publisher;

        public Producer(ApplicationEventPublisher publisher) {
            this.publisher = publisher;
        }

        public void create(String id) {
            publisher.publishEvent(new MedicalRecordUpdatedEvent(id));
        }

        @Async
        public void asyncMethod() {
            logger.info("running async method with thread '{}'", Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(LinApplication.class, args);
    }
}
