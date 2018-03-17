package service;

import dto.CustomerDto;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    public CustomerDto getById(Integer id);

    public List<CustomerDto> getAllCustomers();

    public CustomerDto addNewCustomer(Map<String, String> parametersMap, ServletContext servletContext);
}
