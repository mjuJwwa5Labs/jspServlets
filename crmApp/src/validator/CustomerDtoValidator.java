package validator;

public interface CustomerDtoValidator {

    public boolean notNullObject(Object o);

    public boolean nullObject(Object o);

    public boolean notEmptyString(String s);

}
