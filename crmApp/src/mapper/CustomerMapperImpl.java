package mapper;

import dto.CustomerDto;
import entity.Customer;
import entity.CustomerType;

public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        Integer id = customer.getId();
        String login = customer.getLogin();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        CustomerType customerType = customer.getCustomerType();
        Integer addressId = customer.getAddressId();
        CustomerDto customerDto = new CustomerDto(id,login,firstName,lastName,customerType,addressId);
        return customerDto;
    }

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        Integer id = customerDto.getId();
        String login = customerDto.getLogin();
        String firstName = customerDto.getFirstName();
        String lastName = customerDto.getLastName();
        CustomerType customerType = customerDto.getCustomerType();
        Integer addressId = customerDto.getAddressId();
        Customer customer = new Customer(id,login,firstName,lastName,customerType,addressId);
        return customer;
    }
}
