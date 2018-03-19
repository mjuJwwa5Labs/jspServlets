package asserts;

import entity.Customer;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

public class CustomerOptionalAssert {

    private Optional<Customer> customerOptional;

    public CustomerOptionalAssert(Optional<Customer> customerOptional) {
        this.customerOptional = customerOptional;
    }

    public CustomerOptionalAssert hasId(Integer id) {
        Assert.assertEquals("Id should equals " + id, id, customerOptional.get().getId());
        return this;
    }

    public CustomerOptionalAssert hasFirstname(String firstname) {
        Assert.assertEquals("First name should equals " + firstname, firstname, customerOptional.get().getFirstname());
        return this;
    }

    public CustomerOptionalAssert hasLastname(String lastname) {
        Assert.assertEquals("Last name should equals " + lastname, lastname, customerOptional.get().getLastname());
        return this;
    }

    public CustomerOptionalAssert hasCreationDate(LocalDateTime created) {
        Assert.assertEquals("Creation date should equals " + created, created, customerOptional.get().getCreated());
        return this;
    }

    public CustomerOptionalAssert hasModificationDate(LocalDateTime modified) {
        Assert.assertEquals("Modification date should equals " + modified, modified, customerOptional.get().getModified());
        return this;
    }

}
