package mapper;

import dto.CustomerDto;
import entity.Customer;

import java.time.LocalDateTime;

public class CustomerMapper {

    public Customer from(CustomerDto customerDto) {
        Integer id = customerDto.getId();
        String firstname = customerDto.getFirstname();
        String lastname = customerDto.getLastname();
        LocalDateTime created = customerDto.getCreated();
        LocalDateTime modified = customerDto.getModified();
        return new Customer(id,firstname,lastname,created,modified);
    }

    public CustomerDto from(Customer customer) {
        Integer id = customer.getId();
        String firstname = customer.getFirstname();
        String lastname = customer.getLastname();
        LocalDateTime created = customer.getCreated();
        LocalDateTime modified = customer.getModified();
        return new CustomerDto(id,firstname,lastname,created,modified);
    }

}
