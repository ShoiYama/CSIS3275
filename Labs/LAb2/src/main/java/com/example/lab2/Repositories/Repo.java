package com.example.lab2.Repositories;

import com.example.lab2.Entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repo {

    List<Customer> list1 = new ArrayList<Customer>();

    public ArrayList<Customer> initialpage(){

        Customer cc, dd;

        cc = new Customer();

        cc.setCemail("xxx@yahoo.com");
        cc.setCname("Joe");

        list1.add(cc);

        return (ArrayList<Customer>) list1;
    }

}
