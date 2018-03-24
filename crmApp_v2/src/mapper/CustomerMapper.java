package mapper;

import dto.CustomerDto;
import entity.Customer;
import helpers.LocalDateTimeFormatter;
import helpers.LocalDateTimeFormatterImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerMapper {

    public Customer from(CustomerDto customerDto) {
        LocalDateTimeFormatter formatter = new LocalDateTimeFormatterImpl();

        Integer id = customerDto.getId();
        String firstname = customerDto.getFirstname();
        String lastname = customerDto.getLastname();
        LocalDateTime created = null;
        if (customerDto.getCreated()!=null) {
            created = formatter.from(customerDto.getCreated());
        }
        LocalDateTime modified = null;
        if (customerDto.getModified()!=null) {
            modified = formatter.from(customerDto.getModified());
        }
        return new Customer(id,firstname,lastname,created,modified);
    }

    public CustomerDto from(Customer customer) {
        LocalDateTimeFormatter formatter = new LocalDateTimeFormatterImpl();

        Integer id = customer.getId();
        String firstname = customer.getFirstname();
        String lastname = customer.getLastname();
        String created = null;
        if (customer.getCreated()!=null) {
            created = formatter.from(customer.getCreated());
        }
        String modified = null;
        if (customer.getModified()!=null) {
            modified = formatter.from(customer.getModified());
        }

        return new CustomerDto(id,firstname,lastname,created,modified);
    }

}
