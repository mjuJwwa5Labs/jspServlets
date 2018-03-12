package dto;

import entity.CustomerType;

public class CustomerDto {

    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private CustomerType customerType;
    private Integer addressId;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String login, String firstName, String lastName, CustomerType customerType, Integer addressId) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerType = customerType;
        this.addressId = addressId;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public Integer getAddressId() {
        return addressId;
    }
}
