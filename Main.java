package shopmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShopManagementSystem shop = new ShopManagementSystem();

        // Adding Products
        Product product1 = new Product("P01", "Laptop", 50000, 10);
        Product product2 = new Product("P02", "Mobile", 20000, 20);
        shop.addProduct(product1);
        shop.addProduct(product2);

        // Adding Customers
        Customer customer1 = new Customer("C01", "Alice", "1234567890");
        shop.addCustomer(customer1);

        // Processing a Sale
        List<Product> purchasedProducts = new ArrayList<>();
        purchasedProducts.add(product1);
        purchasedProducts.add(product2);
        
        shop.processSale("T01", customer1, purchasedProducts);

        // Display inventory, customers, and transactions
        System.out.println("\n--- Inventory ---");
        shop.displayInventory();

        System.out.println("\n--- Customers ---");
        shop.displayCustomers();

        System.out.println("\n--- Transactions ---");
        shop.displayTransactions();
    }
}
