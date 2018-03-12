package service;

public class CustomerServiceFactory {

    public static CustomerService factory(String factoryParameter) {
        String parameter = factoryParameter.toLowerCase();
        switch (parameter) {
            case "csv":
                return new CustomerServiceCsvImpl();
            case "memory":
                return new CustomerServiceMemoryImpl();
            default:
                throw new IllegalArgumentException("Wrong parameter for CustomerServiceFactory");
        }
    }

}
