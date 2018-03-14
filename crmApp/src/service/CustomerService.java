package service;

import dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    public CustomerDto getById(Integer id);

    public List<CustomerDto> getAllCustomers();

    public CustomerDto createNewCustomer(CustomerDto customerDto);
}
