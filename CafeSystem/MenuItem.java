package CafeSystem;

/**
 * Paige Grimes
 * CafeSystem.MenuItem.java
 * Part 1: Creating the CafeSystem.MenuItem Class
 */
public class MenuItem {
    // Declare the classes attributes
    private String name;
    private double price;
    private String category;
    // Create the constructor
    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    // Create getters and setters for name, price and category
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void displayItemInfo() {
        // Print out the item's details in a user-friendly format
        System.out.println("Item: " + getName() + ", Price: " + getPrice() + ", Category: " + getCategory());
    }
}
