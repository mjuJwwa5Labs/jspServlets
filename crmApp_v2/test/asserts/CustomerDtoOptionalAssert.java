package asserts;

import dto.CustomerDto;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

public class CustomerDtoOptionalAssert {

    private Optional<CustomerDto> customerOptional;

    public CustomerDtoOptionalAssert(Optional<CustomerDto> customerOptional) {
        this.customerOptional = customerOptional;
    }

    public CustomerDtoOptionalAssert hasId(Integer id) {
        Assert.assertEquals("Id should equals " + id, id, customerOptional.get().getId());
        return this;
    }

    public CustomerDtoOptionalAssert hasFirstname(String firstname) {
        Assert.assertEquals("First name should equals " + firstname, firstname, customerOptional.get().getFirstname());
        return this;
    }

    public CustomerDtoOptionalAssert hasLastname(String lastname) {
        Assert.assertEquals("Last name should equals " + lastname, lastname, customerOptional.get().getLastname());
        return this;
    }

    public CustomerDtoOptionalAssert hasCreationDate(LocalDateTime created) {
        Assert.assertEquals("Creation date should equals " + created, created, customerOptional.get().getCreated());
        return this;
    }

    public CustomerDtoOptionalAssert hasModificationDate(LocalDateTime modified) {
        Assert.assertEquals("Modification date should equals " + modified, modified, customerOptional.get().getModified());
        return this;
    }

}
