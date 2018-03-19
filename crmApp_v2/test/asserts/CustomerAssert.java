package asserts;

import entity.Customer;
import org.junit.Assert;

import java.time.LocalDateTime;

public class CustomerAssert {

    private Customer customer;

    public CustomerAssert(Customer customer) {
        this.customer = customer;
    }

    public CustomerAssert hasId(Integer id) {
        Assert.assertEquals("Id should equals " + id, id, customer.getId());
        return this;
    }

    public CustomerAssert hasFirstname(String firstname) {
        Assert.assertEquals("First name should equals " + firstname, firstname, customer.getFirstname());
        return this;
    }

    public CustomerAssert hasLastname(String lastname) {
        Assert.assertEquals("Last name should equals " + lastname, lastname, customer.getLastname());
        return this;
    }

    public CustomerAssert hasCreationDate(LocalDateTime created) {
        Assert.assertEquals("Creation date should equals " + created, created, customer.getCreated());
        return this;
    }

    public CustomerAssert hasModificationDate(LocalDateTime modified) {
        Assert.assertEquals("Modification date should equals " + modified, modified, customer.getModified());
        return this;
    }
}
