package com.lin.utils.number;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class NumberUtils {
    public static void main(String[] args)  throws Exception{
        List<User> userList=new ArrayList<>();
        userList.add(null);
        userList.add(new User(1L, "aaa", LocalDate.of(2023,3,1)));
//        userList.add(new User(2L, "bbb", LocalDate.of(2023,3,1)));
//        userList.add(new User(3L, "ccc", LocalDate.of(2022,8,1)));
//        userList.add(new User(2L, "ddd", LocalDate.of(2024,5,1)));
//        userList.add(new User(3L, "eee", LocalDate.of(2013,5,1)));


        String name=userList.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(user->user.getCreatedOn()))
                .map(user->{
                    return user.getName();
                }).orElse(null);

        System.out.println("name = " + name);

    }
}

class User{

    Long id;
    String Name;
    LocalDate createdOn;

    public User(Long id, String name) {
        this.id = id;
        Name = name;
    }

    public User(Long id, String name, LocalDate createdOn) {
        this.id = id;
        Name = name;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
