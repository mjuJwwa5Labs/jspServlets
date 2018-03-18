package dao;

import entity.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CustomerDaoImplStaticListTest {

    @Test
    public void shouldGetAllUsers() {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        List<Customer> customerList = customerDao.getAllCustomers();
        Assert.assertTrue("Customer list size should > 0", customerList.size()>0);
    }

    @Test
    public void shouldGetUserWhenExist() {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        Optional<Customer> foundOptional = customerDao.getById(1);
        Assert.assertTrue("Customer should be found ", foundOptional.isPresent());
    }

    @Test
    public void shouldAddNewCustomer() {
        CustomerDao customerDao = new CustomerDaoImplStaticList();
        List<Customer> customerList = customerDao.getAllCustomers();
        Integer sizeBefore = customerList.size();
        Customer customer = new Customer(Integer.MAX_VALUE, "fistname", "lastname", LocalDateTime.now(), LocalDateTime.now());
        customerDao.addNewCustomer(customer);
        customerList = customerDao.getAllCustomers();
        Integer sizeAfter = customerList.size();
        Assert.assertEquals("List size should be bigger with exactly one element", 1, sizeAfter-sizeBefore );
    }

}