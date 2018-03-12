package dao;

import entity.Customer;
import entity.CustomerType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoCsvImpl implements CustomerDao {

    private String customerDbPath ="/resources/customerData.csv";

    @Override
    public Customer getById(Integer id) {
        List<Customer> allCustomers = readCustomersData();
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
        List<Customer> allCustomers = readCustomersData();
        return allCustomers;
    }

    private List<Customer> readCustomersData() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(customerDbPath);
        List<Customer> customerList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = br.readLine();
            while (line != null) {
                String[] lineSplitted = line.split(",");
                Integer id = Integer.valueOf(lineSplitted[0]);
                String login = lineSplitted[1];
                String firstName = lineSplitted[2];
                String lastName = lineSplitted[3];
                CustomerType customerType = CustomerType.valueOf(lineSplitted[4]);
                Integer addressId = Integer.valueOf(lineSplitted[5]);
                customerList.add(new Customer(id,login,firstName,lastName,customerType,addressId));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerList;
    }

}
