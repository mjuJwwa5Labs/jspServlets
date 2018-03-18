package dao;

import entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    public List<Customer> getAllCustomers();

    public Optional<Customer> getById(Integer id);

    public Customer addNewCustomer(Customer customer);

}
