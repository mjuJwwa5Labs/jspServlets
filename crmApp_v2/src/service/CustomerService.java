package service;

import dto.CustomerDto;
import entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<CustomerDto> getAllCustomers();

    public Optional<CustomerDto> getById(Integer id);

    public CustomerDto addNewCustomer(Customer customer);

    public List<CustomerDto> findByCustomerDto(CustomerDto customerDto);

}
