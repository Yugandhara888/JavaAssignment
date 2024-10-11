package shop;
class Customer {
    private String customerId;
    private String customerName;
    private String phoneNumber;

    // Constructor
    public Customer(String customerId, String customerName, String phoneNumber) throws IllegalArgumentException {
        if (customerName.isEmpty() || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid customer name or phone number.");
        }
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters...
    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + customerName + ", Phone: " + phoneNumber;
    }
}
