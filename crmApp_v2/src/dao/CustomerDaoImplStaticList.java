package dao;

import dataSource.CustomerDB;
import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImplStaticList implements CustomerDao {

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = CustomerDB.getCustomerList();
        return customerList;
    }

    @Override
    public Optional<Customer> getById(Integer id) {

        List<Customer> customerList = CustomerDB.getCustomerList();
        for (Customer customer : customerList) {
            if (customer.getId()==id) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        CustomerDB.getCustomerList().add(customer);
        return customer;
    }
}
