package asserts;

import dto.CustomerDto;
import org.junit.Assert;

import java.time.LocalDateTime;

public class CustomerDtoAssert {

    private CustomerDto customerDto;

    public CustomerDtoAssert(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public CustomerDtoAssert hasId(Integer id) {
        Assert.assertEquals("Id should equals " + id, id, customerDto.getId());
        return this;
    }

    public CustomerDtoAssert hasFirstname(String firstname) {
        Assert.assertEquals("First name should equals " + firstname, firstname, customerDto.getFirstname());
        return this;
    }

    public CustomerDtoAssert hasLastname(String lastname) {
        Assert.assertEquals("Last name should equals " + lastname, lastname, customerDto.getLastname());
        return this;
    }

    public CustomerDtoAssert hasCreationDate(LocalDateTime created) {
        Assert.assertEquals("Creation date should equals " + created, created, customerDto.getCreated());
        return this;
    }

    public CustomerDtoAssert hasModificationDate(LocalDateTime modified) {
        Assert.assertEquals("Modification date should equals " + modified, modified, customerDto.getModified());
        return this;
    }
}
