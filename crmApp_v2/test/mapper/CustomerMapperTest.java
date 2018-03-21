package mapper;

import asserts.CustomerAssert;
import dto.CustomerDto;
import entity.Customer;
import org.junit.Test;

import java.time.LocalDateTime;


public class CustomerMapperTest {

    private CustomerAssert customerAssert;

    @Test
    public void shouldMapCustomerDtoToCustomer() {
        CustomerDto customerDto = new CustomerDto(1,"firstname","lastname", LocalDateTime.now(),LocalDateTime.now());
        CustomerMapper mapper = new CustomerMapper();
        Customer customer = mapper.from(customerDto);
        customerAssert = new CustomerAssert(customer);

        customerAssert
                .hasId(customerDto.getId())
                .hasFirstname(customerDto.getFirstname())
                .hasLastname(customerDto.getLastname())
                .hasCreationDate(customerDto.getCreated())
                .hasModificationDate(customerDto.getModified());
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
                .hasCreationDate(customerDto.getCreated())
                .hasModificationDate(customerDto.getModified());
    }

}