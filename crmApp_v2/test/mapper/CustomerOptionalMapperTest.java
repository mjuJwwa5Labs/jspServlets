package mapper;

import asserts.CustomerOptionalAssert;
import dto.CustomerDto;
import entity.Customer;
import helpers.LocalDateTimeFormatter;
import helpers.LocalDateTimeFormatterImpl;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

public class CustomerOptionalMapperTest {

    private CustomerOptionalAssert customerOptionalAssert;
    private LocalDateTimeFormatter formatter;

    @Test
    public void shouldMapCustomerOptionalToCustomerDtoOptional() {
        formatter = new LocalDateTimeFormatterImpl();
        Customer customer = new Customer(1,"firstname","lastname", LocalDateTime.now(),LocalDateTime.now());
        Optional<Customer> customerOptional = Optional.of(customer);
        CustomerOptionalMapper mapper = new CustomerOptionalMapper();
        Optional<CustomerDto> customerDtoOptional = mapper.tooCustomerDtoOptional(customerOptional);
        customerOptionalAssert = new CustomerOptionalAssert(customerOptional);

        customerOptionalAssert
                .hasId(customerDtoOptional.get().getId())
                .hasFirstname(customerDtoOptional.get().getFirstname())
                .hasLastname(customerDtoOptional.get().getLastname())
                .hasCreationDate(formatter.from(customerDtoOptional.get().getCreated()))
                .hasModificationDate(formatter.from(customerDtoOptional.get().getModified()));
    }
}