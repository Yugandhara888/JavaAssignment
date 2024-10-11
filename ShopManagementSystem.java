package shop;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ShopManagementSystem {
    private List<Product> products;
    private List<Customer> customers;
    private List<SaleTransaction> transactions;
    private Scanner scanner;

    public ShopManagementSystem() {
        products = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add product to inventory (with user input)
    public void addProduct() {
        try {
            System.out.println("Enter Product ID: ");
            String productId = scanner.nextLine();
            System.out.println("Enter Product Name: ");
            String productName = scanner.nextLine();
            System.out.println("Enter Product Price: ");
            double price = scanner.nextDouble();
            System.out.println("Enter Product Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Product product = new Product(productId, productName, price, quantity);
            products.add(product);
            System.out.println("Product added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    // Add customer (with user input)
    public void addCustomer() {
        try {
            System.out.println("Enter Customer ID: ");
            String customerId = scanner.nextLine();
            System.out.println("Enter Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.println("Enter Customer Phone (10 digits): ");
            String phoneNumber = scanner.nextLine();

            Customer customer = new Customer(customerId, customerName, phoneNumber);
            customers.add(customer);
            System.out.println("Customer added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error adding customer: " + e.getMessage());
        }
    }

    // Register a sale (with user input)
    public void processSale() {
        try {
            System.out.println("Enter Transaction ID: ");
            String transactionId = scanner.nextLine();
            System.out.println("Enter Customer ID: ");
            String customerId = scanner.nextLine();
            Customer customer = getCustomerById(customerId);

            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }

            List<Product> purchasedProducts = new ArrayList<>();
            String productId;
            while (true) {
                System.out.println("Enter Product ID to purchase (or 'done' to finish): ");
                productId = scanner.nextLine();
                if (productId.equalsIgnoreCase("done")) break;

                Product product = getProductById(productId);
                if (product == null) {
                    System.out.println("Product not found!");
                    continue;
                }

                System.out.println("Enter quantity to purchase: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                product.updateQuantity(quantity);
                purchasedProducts.add(product);
            }

            SaleTransaction transaction = new SaleTransaction(transactionId, customer, purchasedProducts);
            transactions.add(transaction);
            System.out.println("Sale processed: " + transaction);

        } catch (IllegalArgumentException e) {
            System.out.println("Error processing sale: " + e.getMessage());
        }
    }

    // Helper method to find a customer by ID
    private Customer getCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    // Helper method to find a product by ID
    private Product getProductById(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Display inventory
    public void displayInventory() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Display customers
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
