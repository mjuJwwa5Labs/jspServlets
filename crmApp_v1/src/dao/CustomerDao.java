package dao;

import entity.Customer;

import javax.servlet.ServletContext;
import java.util.List;

public interface CustomerDao {

    public Customer getById(Integer id);

    public List<Customer> getAllCustomers();

    public Customer addNewCustomer(Customer customer, ServletContext servletContext);
}
