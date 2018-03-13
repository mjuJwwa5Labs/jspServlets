package validator;

public class CustomerDtoValidatorImpl implements CustomerDtoValidator {

    @Override
    public boolean notNullObject(Object o) {
        return o!=null;
    }

    @Override
    public boolean nullObject(Object o) {
        return o==null;
    }

    @Override
    public boolean notEmptyString(String s) {
        return (s!=null && s.length()>0 && !s.equals(""));
    }
}
