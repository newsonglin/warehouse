package com.lin.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CommonService {

    @Autowired
    private UserService userService;

    @Transactional(rollbackFor = {Exception.class})
    public void createUser() throws Exception{

        try{

            userService.insert();

            throw  new Exception("ddddddd");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
