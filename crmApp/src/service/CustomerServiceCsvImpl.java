package service;

import dao.CustomerDao;
import dao.CustomerDaoCsvImpl;
import dao.CustomerDaoInMemoryImpl;
import dto.CustomerDto;
import entity.Customer;
import entity.CustomerType;
import mapper.CustomerMapper;
import mapper.CustomerMapperImpl;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerServiceCsvImpl implements CustomerService {

    @Override
    public CustomerDto getById(Integer id) {
        CustomerDao customerDao = new CustomerDaoCsvImpl();
        Customer customer = customerDao.getById(id);

        CustomerMapper customerMapper = new CustomerMapperImpl();
        CustomerDto customerDto = customerMapper.toCustomerDto(customer);

        return customerDto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        CustomerDao customerDao = new CustomerDaoCsvImpl();
        List<Customer> customerList = customerDao.getAllCustomers();

        CustomerMapper customerMapper = new CustomerMapperImpl();

        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto customerDto = customerMapper.toCustomerDto(customer);
            customerDtoList.add(customerDto);
        }

        return customerDtoList;
    }

    @Override
    public CustomerDto addNewCustomer(Map<String, String> parametersMap, ServletContext servletContext) {
        Integer id = null;
        String login = parametersMap.get("login");
        String firstName = parametersMap.get("firstName");
        String lastName = parametersMap.get("lastName");
        CustomerType customerType = null;
        Integer addressId = null;

        if (parametersMap.containsKey("id")) {
            id = Integer.valueOf(parametersMap.get("id"));
        } else {
            id = getMaxIdAndIncrement();
        }

        if (parametersMap.containsKey("customerType")) {
            customerType = CustomerType.valueOf(parametersMap.get("customerType"));
        } else {
            customerType = CustomerType.REGULAR;
        }

        if (parametersMap.containsKey("addressId")) {
            addressId = Integer.valueOf(parametersMap.get("addressId"));
        } else {
            addressId = 99999;
        }

        Customer customer = new Customer(id,login,firstName,lastName,customerType,addressId);
        CustomerDao customerDao = new CustomerDaoCsvImpl();
        Customer addedCustomer = customerDao.addNewCustomer(customer, servletContext);

        if (addedCustomer==null) {
            throw new IllegalStateException("Błąd podczas dodawania nowego klienta");
        }

        return new CustomerMapperImpl().toCustomerDto(customer);
    }

    private Integer getMaxIdAndIncrement() {
        CustomerDao customerDao = new CustomerDaoCsvImpl();
        List<Customer> customerList = customerDao.getAllCustomers();

        Integer max = customerList.get(0).getId();

        for (Customer customer : customerList) {
            if (max<customer.getId()) {
                max=customer.getId();
            }
        }

        return ++max;
    }
}
