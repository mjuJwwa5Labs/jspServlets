package mapper;

import dto.CustomerDto;
import entity.Customer;

public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        Integer id = customer.getId();
        String customerName = customer.getCustomerName();
        String customerEmail = customer.getCustomerEmail();
        String customerPhone = customer.getCustomerPhone();
        CustomerDto customerDto = new CustomerDto(id,customerName,customerEmail,customerPhone);
        return customerDto;
    }

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        Integer id = customerDto.getId();
        String customerName = customerDto.getCustomerName();
        String customerEmail = customerDto.getCustomerEmail();
        String customerPhone = customerDto.getCustomerPhone();
        Customer customer = new Customer(id,customerName,customerEmail,customerPhone);
        return customer;
    }
}
