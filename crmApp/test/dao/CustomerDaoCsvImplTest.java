package dao;

import entity.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CustomerDaoCsvImplTest {

    CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        customerDao = new CustomerDaoCsvImpl();
    }

    @Test
    public void shouldFindByIdWhenExists() {
        //given
        List<Customer> allCustomers = customerDao.getAllCustomers();
        Customer existingCustomer = allCustomers.get(0);
        Integer existingCustomerId = existingCustomer.getId();

        //when
        Customer foundCustomer = customerDao.getById(existingCustomerId);

        //then
        Assert.assertEquals("Customer id should be " + existingCustomer.getId(),existingCustomer.getId(),foundCustomer.getId());
        Assert.assertEquals("Customer name should be " + existingCustomer.getCustomerName(),existingCustomer.getCustomerName(),foundCustomer.getCustomerName());
        Assert.assertEquals("Customer phone should be " + existingCustomer.getCustomerPhone(),existingCustomer.getCustomerPhone(),foundCustomer.getCustomerPhone());
        Assert.assertEquals("Customer email should be " + existingCustomer.getCustomerEmail(),existingCustomer.getCustomerEmail(),foundCustomer.getCustomerEmail());
    }

    @Test
    public void shouldGetAllCustomers() {
        //given-when
        List<Customer> allCustomers = customerDao.getAllCustomers();

        //then
        Assert.assertTrue("List size should be greater than 0", allCustomers.size()>0);
        Assert.assertTrue("First customer id should be number greater than 0", allCustomers.get(0).getId()>0);
        Assert.assertTrue("First customer name length should be greater than 0", allCustomers.get(0).getCustomerName().length()>0);
        Assert.assertTrue("First customer phone number length should be greater than 0", allCustomers.get(0).getCustomerPhone().length()>0);
        Assert.assertTrue("First customer email addres length should be greater than 0", allCustomers.get(0).getCustomerEmail().length()>0);

        String customerEmail = allCustomers.get(0).getCustomerEmail();
        String[] customerEmailArray = customerEmail.split("@");

        Assert.assertEquals("First customer email addres should contain exactly one @ character", 2,customerEmailArray.length);

    }
}