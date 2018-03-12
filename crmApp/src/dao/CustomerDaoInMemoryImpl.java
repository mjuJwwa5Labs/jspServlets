package dao;

import entity.Customer;
import entity.CustomerType;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoInMemoryImpl implements CustomerDao {

    String customerDb;

    @Override
    public Customer getById(Integer id) {
        List<Customer> allCustomers = parseCsvToCustomerData();
        Customer foundCustomer = null;
        for (Customer customer : allCustomers) {
            if (id == customer.getId()) {
                foundCustomer = customer;
            }
        }
        return foundCustomer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = parseCsvToCustomerData();
        return allCustomers;
    }

    private List<Customer> parseCsvToCustomerData() {
        List<Customer> customerList = new ArrayList<>();
        String[] customersCsv = createCsv();

        for (String line : customersCsv) {
            String[] lineSplitted = line.split(",");
            Integer id = Integer.valueOf(lineSplitted[0]);
            String login = lineSplitted[1];
            String firstName = lineSplitted[2];
            String lastName = lineSplitted[3];
            CustomerType customerType = CustomerType.valueOf(lineSplitted[4]);
            Integer addressId = Integer.valueOf(lineSplitted[5]);
            customerList.add(new Customer(id,login,firstName,lastName,customerType,addressId));
        }
        return customerList;
    }

    private String[] createCsv() {

        String[] emulatedCsv = new String[7];

        emulatedCsv[0] = "1,Diane.King@fakegmail.com,Diane,King,REGULAR,13";
        emulatedCsv[1] = "2,Jimmy.Wilson@fakegmail.com,Jimmy,Wilson,REGULAR,14";
        emulatedCsv[2] = "3,Virginia.Gonzalez@fakegmail.com,Virginia,Gonzalez,REGULAR,18";
        emulatedCsv[3] = "4,Joyce.Miller@fakegmail.com,Joyce,Miller,REGULAR,45";
        emulatedCsv[4] = "5,Jonathan.Morris@fakegmail.com,Jonathan,Morris,VIP,70";
        emulatedCsv[5] = "6,Sean.Hall@fakegmail.com,Sean,Hall,REGULAR,72";
        emulatedCsv[6] = "7,Brian.Robinson@fakegmail.com,Brian,Robinson,VIP,82";

        return emulatedCsv;
    }

}
