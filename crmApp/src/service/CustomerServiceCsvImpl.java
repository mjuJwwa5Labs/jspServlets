package service;

import dao.CustomerDao;
import dao.CustomerDaoCsvImpl;
import dao.CustomerDaoInMemoryImpl;
import dto.CustomerDto;
import entity.Customer;
import mapper.CustomerMapper;
import mapper.CustomerMapperImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceCsvImpl implements CustomerService {

    @Override
    public CustomerDto getById(Integer id) {
        CustomerDao customerDao = new CustomerDaoInMemoryImpl();
//        CustomerDao customerDao = new CustomerDaoCsvImpl();
        Customer customer = customerDao.getById(id);

        CustomerMapper customerMapper = new CustomerMapperImpl();
        CustomerDto customerDto = customerMapper.toCustomerDto(customer);

        return customerDto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        CustomerDao customerDao = new CustomerDaoInMemoryImpl();
//        CustomerDao customerDao = new CustomerDaoCsvImpl();
        List<Customer> customerList = customerDao.getAllCustomers();

        CustomerMapper customerMapper = new CustomerMapperImpl();

        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDto customerDto = customerMapper.toCustomerDto(customer);
            customerDtoList.add(customerDto);
        }

        return customerDtoList;
    }
}
