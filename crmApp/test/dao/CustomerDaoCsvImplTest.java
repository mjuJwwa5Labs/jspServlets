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
        Assert.assertEquals("Customer first name should be " + existingCustomer.getFirstName(),existingCustomer.getFirstName(),foundCustomer.getFirstName());
        Assert.assertEquals("Customer last name should be " + existingCustomer.getLastName(),existingCustomer.getLastName(),foundCustomer.getLastName());
    }

    @Test
    public void shouldGetAllCustomers() {
        //given-when
        List<Customer> allCustomers = customerDao.getAllCustomers();

        //then
        Assert.assertTrue("List size should be greater than 0", allCustomers.size()>0);
        Assert.assertTrue("First customer id should be number greater than 0", allCustomers.get(0).getId()>0);
        Assert.assertTrue("First customer first name length should be greater than 0", allCustomers.get(0).getFirstName().length()>0);
        Assert.assertTrue("First customer last name length should be greater than 0", allCustomers.get(0).getLastName().length()>0);
        Assert.assertTrue("First customer login length should be greater than 0", allCustomers.get(0).getLogin().length()>0);
    }
}