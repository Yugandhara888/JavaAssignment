package shop;
import java.util.List;

class SaleTransaction {
    private String transactionId;
    private Customer customer;
    private List<Product> purchasedProducts;
    private double totalAmount;

    // Constructor
    public SaleTransaction(String transactionId, Customer customer, List<Product> purchasedProducts) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.purchasedProducts = purchasedProducts;
        this.totalAmount = calculateTotal();
    }

    // Method to calculate total amount of the sale
    private double calculateTotal() {
        double total = 0;
        for (Product product : purchasedProducts) {
            total += product.getPrice();
        }
        return total;
    }

    public String getTransactionId() { return transactionId; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Customer: " + customer.getCustomerName() + 
               ", Total Amount: " + totalAmount;
    }
}
