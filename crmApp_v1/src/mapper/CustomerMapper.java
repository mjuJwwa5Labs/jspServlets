package mapper;

import dto.CustomerDto;
import entity.Customer;

import java.util.Map;

public interface CustomerMapper {

    public CustomerDto toCustomerDto(Customer customer);

    public Customer toCustomer(CustomerDto customerDto);

    public CustomerDto toCustomerDtoWithoutEmptyStrings(CustomerDto customerDto);

    public CustomerDto toCustomerDtoFromMap(Map<String,String> parametersMap);

}
