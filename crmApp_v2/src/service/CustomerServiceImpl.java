package service;

import dao.CustomerDao;
import dao.CustomerDaoImplStaticList;
import dto.CustomerDto;
import entity.Customer;
import helpers.CustomerDtoFinderComparator;
import mapper.CustomerMapper;
import mapper.CustomerOptionalMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    //CREATE
    @Override
    public CustomerDto addNewCustomer(Customer customer) {
        CustomerDao customerDao = new CustomerDaoImplStaticList();

        if (customer.getId()==null) {
            Integer id = this.autoIncrementId();
            customer.setId(id);
        }

        CustomerMapper mapper = new CustomerMapper();
        Customer addedCustomer = customerDao.addNewCustomer(customer);
        return mapper.from(addedCustomer);
    }

    //READ
    @Override
    public List<CustomerDto> getAllCustomers() {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        CustomerMapper mapper = new CustomerMapper();

        List<Customer> customerList = customerDao.getAllCustomers();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        customerList
                .stream()
                .forEach((c) -> customerDtoList.add(mapper.from(c)));


        return customerDtoList;
    }

    @Override
    public Optional<CustomerDto> getById(Integer id) {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        Optional<Customer> customer = customerDao.getById(id);
        CustomerOptionalMapper mapper = new CustomerOptionalMapper();
        Optional<CustomerDto> customerDto = mapper.tooCustomerDtoOptional(customer);
        return customerDto;
    }

    @Override
    public List<CustomerDto> findByCustomerDto(CustomerDto customerDto) {
        List<CustomerDto> customerDtoList = this.getAllCustomers();
        CustomerDto customerDtoToFind = customerDto;
        List<CustomerDto> foundCustomers = new ArrayList<>();
        CustomerDtoFinderComparator comparator = new CustomerDtoFinderComparator();

        for (CustomerDto customerDtoElement : customerDtoList) {
            int compareResult = comparator.compare(customerDtoElement,customerDtoToFind);
            if (compareResult==0) {
                foundCustomers.add(customerDtoElement);
            }
        }
        return foundCustomers;
    }

    //UPDATE
    //DELETE

    //private methods
    private Integer autoIncrementId() {
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
        return ++id;
    }
}
