package mapper;

import dto.CustomerDto;
import entity.Customer;
import entity.CustomerType;

import java.util.Map;

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

    @Override
    public CustomerDto toCustomerDtoWithoutEmptyStrings(CustomerDto customerDto) {

        Integer id = null;
        String login = null;
        String firstName = null;
        String lastName = null;
        CustomerType customerType = null;
        Integer addressId = null;

        if (customerDto.getId()!=null) {
            id = customerDto.getId();
        }

        if (customerDto.getLogin()!=null && customerDto.getLogin()!="") {
            login = customerDto.getLogin();
        }

        if (customerDto.getFirstName()!=null && customerDto.getFirstName()!="") {
            firstName = customerDto.getFirstName();
        }

        if (customerDto.getLastName()!=null && customerDto.getLastName()!="") {
            lastName = customerDto.getLastName();
        }

        if (customerDto.getCustomerType()!=null) {
            customerType = customerDto.getCustomerType();
        }

        if (customerDto.getAddressId()!=null) {
            addressId = customerDto.getAddressId();
        }

        return new CustomerDto(id,login,firstName,lastName,customerType,addressId);
    }

    @Override
    public CustomerDto toCustomerDtoFromMap(Map<String, String> parametersMap) {

        String login = parametersMap.get("login");
        String firstName = parametersMap.get("firstName");
        String lastName = parametersMap.get("lastName");

        CustomerDto customerDto = new CustomerDto(null,login,firstName,lastName,null,null);

        return customerDto;
    }
}
