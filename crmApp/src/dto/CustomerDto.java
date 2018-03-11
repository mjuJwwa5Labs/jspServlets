package dto;

public class CustomerDto {

    private Integer id;
    private String customerName;
    private String customerPhone;
    private String customerEmail;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String customerName, String customerPhone, String customerEmail) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
    }

    public Integer getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
