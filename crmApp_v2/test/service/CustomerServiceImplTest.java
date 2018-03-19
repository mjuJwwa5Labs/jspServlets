package service;

import asserts.CustomerDtoAssert;
import asserts.CustomerDtoOptionalAssert;
import dto.CustomerDto;
import entity.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImplTest {

    CustomerService customerService;
    CustomerDtoAssert customerDtoAssert;
    CustomerDtoOptionalAssert customerDtoOptionalAssert;

    @Before
    public void setUp() {
        customerService = new CustomerServiceImpl();
    }

    @Test
    public void shouldGetAllCustomerDtos() {
        List<CustomerDto> customerDtoList = customerService.getAllCustomers();
        Assert.assertNotNull("CustomerDto list can't be null ", customerDtoList);
        Assert.assertTrue("CustomerDto list has to be greater than 0", customerDtoList.size()>0);
        Assert.assertTrue("CustomerDto list should contain at least one CustomerDto object", CustomerDto.class.isInstance(customerDtoList.get(0)));
    }

    @Test
    public void shouldGetCustomerDtoById() {
        List<CustomerDto> customerDtoList = customerService.getAllCustomers();
        CustomerDto customerDto = customerDtoList.get(0);
        Optional<CustomerDto> foundCustomerDto = customerService.getById(customerDto.getId());

        Assert.assertTrue("Optional.of(CustomerDto) should be present", foundCustomerDto.isPresent());
        customerDtoAssert = new CustomerDtoAssert(customerDto);
        customerDtoAssert
                .hasId(foundCustomerDto.get().getId())
                .hasFirstname(foundCustomerDto.get().getFirstname())
                .hasLastname(foundCustomerDto.get().getLastname())
                .hasCreationDate(foundCustomerDto.get().getCreated())
                .hasModificationDate(foundCustomerDto.get().getModified());
    }

    @Test
    public void shouldAddNewCustomerWithoutId() {
        Customer customer = new Customer(null,"firstname","lastname", LocalDateTime.now(),LocalDateTime.now());

        List<CustomerDto> listBefore = customerService.getAllCustomers();
        CustomerDto addedCustomerDto = customerService.addNewCustomer(customer);
        List<CustomerDto> listAfter = customerService.getAllCustomers();
        Integer incrementedId = this.getIncrementedId(listBefore);

        Optional<CustomerDto> foundCustomer = customerService.getById(incrementedId);

        Assert.assertEquals("List size should incerement by 1 after new customer has been added ", 1, listAfter.size()-listBefore.size());
        customerDtoAssert = new CustomerDtoAssert(addedCustomerDto);
        //compare addedCustomerDto to original customer
        customerDtoAssert
                .hasId(incrementedId)
                .hasFirstname(customer.getFirstname())
                .hasLastname(customer.getLastname())
                .hasCreationDate(customer.getCreated())
                .hasModificationDate(customer.getModified());

        //compare addedCustomerDto to customer foundById
        customerDtoOptionalAssert = new CustomerDtoOptionalAssert(foundCustomer);
        customerDtoOptionalAssert
                .hasId(addedCustomerDto.getId())
                .hasFirstname(addedCustomerDto.getFirstname())
                .hasLastname(addedCustomerDto.getLastname())
                .hasCreationDate(addedCustomerDto.getCreated())
                .hasModificationDate(addedCustomerDto.getModified());

    }

    @Test
    public void shouldAddNewCustomerWithId() {
        List<CustomerDto> listBefore = customerService.getAllCustomers();
        Integer incrementedId = this.getIncrementedId(listBefore);
        Customer customer = new Customer(incrementedId,"firstname","lastname", LocalDateTime.now(),LocalDateTime.now());
        CustomerDto addedCustomerDto = customerService.addNewCustomer(customer);
        List<CustomerDto> listAfter = customerService.getAllCustomers();
        Optional<CustomerDto> foundCustomer = customerService.getById(incrementedId);

        Assert.assertEquals("List size should incerement by 1 after new customer has been added ", 1, listAfter.size()-listBefore.size());
        customerDtoAssert = new CustomerDtoAssert(addedCustomerDto);
        //compare addedCustomerDto to original customer
        customerDtoAssert
                .hasId(incrementedId)
                .hasFirstname(customer.getFirstname())
                .hasLastname(customer.getLastname())
                .hasCreationDate(customer.getCreated())
                .hasModificationDate(customer.getModified());

        //compare addedCustomerDto to customer foundById
        customerDtoOptionalAssert = new CustomerDtoOptionalAssert(foundCustomer);
        customerDtoOptionalAssert
                .hasId(addedCustomerDto.getId())
                .hasFirstname(addedCustomerDto.getFirstname())
                .hasLastname(addedCustomerDto.getLastname())
                .hasCreationDate(addedCustomerDto.getCreated())
                .hasModificationDate(addedCustomerDto.getModified());

    }

    private Integer getIncrementedId(List<CustomerDto> customerDtoList) {
        Integer incrementedId = customerDtoList
                .stream()
                .map(cust -> cust.getId())
                .max((max1,max2)-> Integer.compare(max1,max2))
                .get()
                +1;
        return incrementedId;
    }

}