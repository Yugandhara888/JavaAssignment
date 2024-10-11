package shop;
class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;

    // Constructor
    public Product(String productId, String productName, double price, int quantity) throws IllegalArgumentException {
        if (price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Price and quantity cannot be negative.");
        }
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters...
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void updateQuantity(int soldQuantity) throws IllegalArgumentException {
        if (soldQuantity > this.quantity) {
            throw new IllegalArgumentException("Insufficient stock for product: " + productName);
        }
        this.quantity -= soldQuantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

