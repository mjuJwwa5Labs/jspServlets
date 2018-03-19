package validators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CustomerFindFormIdIntegerValidatorTest {

    Validator validator;
    Errors errors;

    @Before
    public void setUp() {
        validator = new CustomerFindFormIdIntegerValidator();
        errors = new Errors();
    }

    @Test
    public void shouldBeFineWhenInteger() {
        Integer i = 1;
        validator.validate(i,errors);
        Assert.assertNull("Errors map should be null", errors.getErrors());
    }

    @Test
    public void shouldBeErrorWhenString() {
        String s = "s";
        validator.validate(s,errors);
        Assert.assertEquals("Expected error: Wprowadź liczbę całkowitą", "Wprowadź liczbę całkowitą", errors.getErrorMessages("id").get(0));
    }

    @Test
    public void shouldBeErrorWhenZero() {
        Integer i = 0;
        validator.validate(i,errors);
        Assert.assertEquals("Expected error: Wprowadź liczbę całkowitą", "Id nie możę być mniejsze niż 1", errors.getErrorMessages("id").get(0));
    }

}