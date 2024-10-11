package shop;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ShopManagementSystem shop = new ShopManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Shop Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Add Customer");
            System.out.println("3. Process Sale");
            System.out.println("4. Display Inventory");
            System.out.println("5. Display Customers");
            System.out.println("6. Display Transactions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    shop.addProduct();
                    break;
                case 2:
                    shop.addCustomer();
                    break;
                case 3:
                    shop.processSale();
                    break;
                case 4:
                    shop.displayInventory();
                    break;
                case 5:
                    shop.displayCustomers();
                    break;
                case 6:
                    shop.displayTransactions();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
