package dao;

import entity.Customer;

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
            String customerName = lineSplitted[1];
            String customerPhone = lineSplitted[2];
            String customerEmail = lineSplitted[3];
            customerList.add(new Customer(id,customerName,customerPhone,customerEmail));
        }
        return customerList;
    }

    private String[] createCsv() {

        String[] emulatedCsv = new String[7];

        emulatedCsv[0] = "1,Diane King,699489207,Diane.King@fakegmail.com";
        emulatedCsv[1] = "2,Jimmy Wilson,799580212,Jimmy.Wilson@fakegmail.com";
        emulatedCsv[2] = "3,Virginia Gonzalez,697177931,Virginia.Gonzalez@fakegmail.com";
        emulatedCsv[3] = "4,Joyce Miller,884629703,Joyce.Miller@fakegmail.com";
        emulatedCsv[4] = "5,Jonathan Morris,733163128,Jonathan.Morris@fakegmail.com";
        emulatedCsv[5] = "6,Sean Hall,722917018,Sean.Hall@fakegmail.com";
        emulatedCsv[6] = "7,Brian Robinson,666975536,Brian.Robinson@fakegmail.com";

        return emulatedCsv;
    }

}
