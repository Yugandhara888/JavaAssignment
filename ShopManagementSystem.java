package shopmanagementsystem;
import java.util.ArrayList;
import java.util.List;

class ShopManagementSystem {
    private List<Product> products;
    private List<Customer> customers;
    private List<SaleTransaction> transactions;

    public ShopManagementSystem() {
        products = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Add product to inventory
    public void addProduct(Product product) {
        products.add(product);
    }

    // Add customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Register a sale
    public void processSale(String transactionId, Customer customer, List<Product> purchasedProducts) {
        SaleTransaction transaction = new SaleTransaction(transactionId, customer, purchasedProducts);
        transactions.add(transaction);
        for (Product product : purchasedProducts) {
            product.updateQuantity(1);  // assuming the customer bought 1 unit of each product
        }
        System.out.println("Sale processed: " + transaction);
    }

    // Display inventory
    public void displayInventory() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Display customer details
    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Display sales transactions
    public void displayTransactions() {
        for (SaleTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
