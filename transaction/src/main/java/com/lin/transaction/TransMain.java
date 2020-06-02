package com.lin.transaction;

import com.lin.transaction.config.AppConfig;
import com.lin.transaction.service.CommonService;
import com.lin.transaction.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransMain {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService bean = context.getBean(UserService.class);
        CommonService commonService = context.getBean(CommonService.class);

        bean.select();


        try {
            commonService.createUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

        bean.select();

    }
}
