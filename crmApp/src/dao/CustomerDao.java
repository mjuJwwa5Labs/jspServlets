package dao;

import entity.Customer;

import java.util.List;

public interface CustomerDao {

    public Customer getById(Integer id);

    public List<Customer> getAllCustomers();

}
