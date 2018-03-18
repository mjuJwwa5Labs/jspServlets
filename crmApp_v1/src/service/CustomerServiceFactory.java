package service;

public class CustomerServiceFactory {

    public static CustomerService factory(CustomerServiceFactoryEnum factoryParameter) {
        switch (factoryParameter) {
            case CSV:
                return new CustomerServiceCsvImpl();
            case MEMOMRY:
                return new CustomerServiceMemoryImpl();
            default:
                throw new IllegalArgumentException("Wrong parameter for CustomerServiceFactory");
        }
    }

}
