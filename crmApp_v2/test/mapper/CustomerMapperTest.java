package mapper;

import asserts.CustomerAssert;
import dto.CustomerDto;
import entity.Customer;
import helpers.LocalDateTimeFormatter;
import helpers.LocalDateTimeFormatterImpl;
import org.junit.Test;

import java.time.LocalDateTime;


public class CustomerMapperTest {

    private CustomerAssert customerAssert;
    private LocalDateTimeFormatter formatter;

    @Test
    public void shouldMapCustomerDtoToCustomer() {
        formatter = new LocalDateTimeFormatterImpl();
        CustomerDto customerDto = new CustomerDto(1,"firstname","lastname", formatter.from(LocalDateTime.now()),formatter.from(LocalDateTime.now()));
        CustomerMapper mapper = new CustomerMapper();
        Customer customer = mapper.from(customerDto);
        customerAssert = new CustomerAssert(customer);

        customerAssert
                .hasId(customerDto.getId())
                .hasFirstname(customerDto.getFirstname())
                .hasLastname(customerDto.getLastname())
                .hasCreationDate(formatter.from(customerDto.getCreated()))
                .hasModificationDate(formatter.from(customerDto.getModified()));
    }

    @Test
    public void shouldMapCustomerToCustomerDto() {
        Customer customer = new Customer(1,"firstname","lastname", LocalDateTime.now(),LocalDateTime.now());
        CustomerMapper mapper = new CustomerMapper();
        CustomerDto customerDto = mapper.from(customer);
        customerAssert = new CustomerAssert(customer);

        customerAssert
                .hasId(customerDto.getId())
                .hasFirstname(customerDto.getFirstname())
                .hasLastname(customerDto.getLastname())
                .hasCreationDate(formatter.from(customerDto.getCreated()))
                .hasModificationDate(formatter.from(customerDto.getModified()));
    }

}