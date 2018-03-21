package mapper;

import dto.CustomerDto;
import entity.Customer;

import java.util.Optional;

public class CustomerOptionalMapper {

    public Optional<CustomerDto> tooCustomerDtoOptional(Optional<Customer> customerOptional) {
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            CustomerMapper customerMapper = new CustomerMapper();
            CustomerDto customerDto = customerMapper.from(customer);
            return Optional.of(customerDto);
        }

        return Optional.empty();
    }

}
