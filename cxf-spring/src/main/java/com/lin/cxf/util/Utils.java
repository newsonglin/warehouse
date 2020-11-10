package com.lin.cxf.util;

import com.lin.cxf.vo.Customer;
import com.sun.xml.internal.ws.developer.Serialization;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void main(String[] args) {
        Customer c = new Customer();
        c.setAge(111);
        c.setName("Hahaaa");
        Customer c2 = new Customer();
        c2.setAge(111);
        c2.setName("Hahaaa");

        ArrayList<Customer> list = new ArrayList<>();
        list.add(c);
        list.add(c2);

        byte[] bytes = SerializationUtils.serialize((Serializable) list);

        Object o = SerializationUtils.deserialize(bytes);

        if(o instanceof  Customer){
            System.out.println(((Customer)o).getName());
        }
    }
}
