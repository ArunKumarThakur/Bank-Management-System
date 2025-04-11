package Entities;

public class Customer {
    private String customerName;
    private String customerId;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String aadharNumber;
    private String panNumber;

    //Default constructor;
    public Customer(){};


    public Customer(String id, String name, String email){
        this.customerId = id;
        this.customerName = name;
        this.email = email;
    }

    public Customer(String customerName, String customerId, String email, String phoneNumber, String address, String dateOfBirth, String aadharNumber, String panNumber) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customerId != null ? customerId.equals(customer.customerId) : customer.customerId == null;
    }

    @Override
    public int hashCode() {
        return customerId != null ? customerId.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", panNumber='" + panNumber + '\'' +
                '}';
    }
}
