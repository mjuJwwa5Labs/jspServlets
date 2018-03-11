package mapper;

import dto.CustomerDto;
import entity.Customer;

public interface CustomerMapper {

    public CustomerDto toCustomerDto(Customer customer);

    public Customer toCustomer(CustomerDto customerDto);

}
