package dataSource;

import entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

    private static List<Customer> customerList;

    public static List<Customer> getCustomerList() {
        if (customerList==null) {
            customerList = new ArrayList<>();
            createCustomers();
        }
        return customerList;
    }

    private static void createCustomers() {
        customerList.add(new Customer(1,"Diane","King",
                LocalDateTime.of(1998,6,27,10,43),
                LocalDateTime.of(2015,1,10,5,33)));
        customerList.add(new Customer(2,"Jimmy","Wilson",
                LocalDateTime.of(1999,2,10,15,12),
                LocalDateTime.of(2012,12,11,5,33)));
        customerList.add(new Customer(3,"Virgina","Gonzales",
                LocalDateTime.of(2018,3,5,2,56),
                LocalDateTime.of(2018,4,12,5,33)));
        customerList.add(new Customer(4,"Jonathan","Morris",
                LocalDateTime.of(2010,4,14,20,43),
                LocalDateTime.of(2012,8,13,17,33)));
        customerList.add(new Customer(5,"Sean","Hall",
                LocalDateTime.of(2000,8,11,16,12),
                LocalDateTime.of(2001,1,14,19,33)));
        customerList.add(new Customer(6,"Brian","Robinson",
                LocalDateTime.of(1993,9,7,5,9),
                LocalDateTime.of(1999,11,15,4,33)));
    }

}
