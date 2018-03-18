package service;

import dao.CustomerDao;
import dao.CustomerDaoImplStaticList;
import dto.CustomerDto;
import entity.Customer;
import mapper.CustomerMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<CustomerDto> getAllCustomers() {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        CustomerMapper customerMapper = new CustomerMapper();

        List<Customer> customerList = customerDao.getAllCustomers();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        customerList
                .stream()
                .forEach((c) -> customerDtoList.add(customerMapper.customerToCustomerDto(c)));


        return customerDtoList;
    }

    @Override
    //todo refaoktoring na użycie CustomerDto
    public Optional<Customer> getById(Integer id) {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        return customerDao.getById(id);
    }

    @Override
    //todo refaoktoring na użycie CustomerDto
    public Customer addNewCustomer(Customer customer) {
        CustomerDao customerDao = new CustomerDaoImplStaticList();

        if (customer.getId()==null) {
            Integer id = this.getNewestId();
            customer.setId(id);
        }

        Customer addedCustomer = customerDao.addNewCustomer(customer);
        return addedCustomer;
    }

    private Integer getNewestId() {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        List<Customer> customerList = customerDao.getAllCustomers();

        if (customerList==null || customerList.size()==0) {
            return 1;
        }

        Integer id = customerList
                .stream()
                .map(customer -> customer.getId())
                .max((max1,max2)-> Integer.compare(max1,max2))
                .get();
        return id;
    }
}
