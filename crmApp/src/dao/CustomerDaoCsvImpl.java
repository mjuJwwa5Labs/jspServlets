package dao;

import entity.Customer;
import entity.CustomerType;

import javax.servlet.ServletContext;
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

    @Override
    public Customer addNewCustomer(Customer customer, ServletContext servletContext) {
        String customerLine = customerToCsvLine(customer);
        String filePath = servletContext.getRealPath("WEB-INF");
        filePath = filePath + "/classes" + customerDbPath;

        try {
            OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStream);
            System.out.println("Próbuję zapisać");
            bufferedWriter.write(customerLine);
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customer;
    }

    private String customerToCsvLine(Customer customer) {
        StringBuilder stringBuilder = new StringBuilder();
        //99,Dorothy.Jones@fakegmail.com,Dorothy,Jones,VIP,970
        stringBuilder.append(customer.getId())
                .append(",")
                .append(customer.getLogin())
                .append(",")
                .append(customer.getFirstName())
                .append(",")
                .append(customer.getLastName())
                .append(",")
                .append(String.valueOf(customer.getCustomerType()))
                .append(",")
                .append(customer.getAddressId());

        return stringBuilder.toString();
    }
}
