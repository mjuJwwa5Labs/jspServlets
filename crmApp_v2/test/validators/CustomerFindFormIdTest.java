package validators;

import dto.CustomerDto;
import helpers.LocalDateTimeFormatter;
import helpers.LocalDateTimeFormatterImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import validators.customerFindForm.CustomerFindFormId;

import java.time.LocalDateTime;

public class CustomerFindFormIdTest {

    Validator validator;
    Errors errors;
    CustomerDto customerDto;
    LocalDateTimeFormatter formatter;

    @Before
    public void setUp() {
        validator = new CustomerFindFormId();
        errors = new Errors();
        formatter = new LocalDateTimeFormatterImpl();
    }

    @Test
    public void shouldBeFineWhenCustomerDtoIdIsCorrect() {
        customerDto = new CustomerDto(1,"a","b", formatter.from(LocalDateTime.now()),formatter.from(LocalDateTime.now()));
        validator.validate(customerDto,errors);
        Assert.assertNull("Errors map should be null", errors.getErrors());
    }

    @Test
    public void shouldBeErrorWhenCustomerDtoIdIsZero() {
        customerDto = new CustomerDto(0,"a","b", formatter.from(LocalDateTime.now()),formatter.from(LocalDateTime.now()));
        validator.validate(customerDto,errors);
        Assert.assertEquals("Expected error: Id nie możę być mniejsze niż 1", "Id nie możę być mniejsze niż 1", errors.getErrorMessages("id").get(0));
    }

    @Test
    public void shouldBeFineWhenCustomerDtoIdIsNull() {
        customerDto = new CustomerDto(null,"a","b", formatter.from(LocalDateTime.now()),formatter.from(LocalDateTime.now()));
        validator.validate(customerDto,errors);
        Assert.assertNull("Errors map should be null", errors.getErrors());
    }

    @Test
    public void shouldBeFineWhenIntegerForInteger() {
        String s = "1";
        validator.validate(s,errors);
        Assert.assertNull("Errors map should be null", errors.getErrors());
    }

    @Test
    public void shouldBeErrorWhenStringForInteger() {
        String s = "s";
        validator.validate(s,errors);
        Assert.assertEquals("Expected error: Wprowadź liczbę całkowitą", "Wprowadź liczbę całkowitą", errors.getErrorMessages("id").get(0));
    }

    @Test
    public void shouldBeErrorWhenZeroForInteger() {
        String s = "0";
        validator.validate(s,errors);
        Assert.assertEquals("Expected error:Id nie możę być mniejsze niż 1", "Id nie możę być mniejsze niż 1", errors.getErrorMessages("id").get(0));
    }

}