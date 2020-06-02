package com.lin.transaction.service;

import com.lin.transaction.dao.UserDao;
import com.lin.transaction.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional
    public void insert(){
        User user = new User("hello", "pass");
        userDao.insert(user);
    }


    public void select() {
        List<Map<String, Object>> list = userDao.select();
        int size=(list==null?-1:list.size());
        System.out.println("============select==================="+size);

        if(size==-1){
            return;
        }
        for(int i=0;i<size;i++){
            Map<String, Object> map=list.get(i);
            for(String key:map.keySet()){
                String fieldName=key;
                System.out.print(fieldName+"-->"+map.get(fieldName)+" | ");
            }
            System.out.println();

        }

    }

}
