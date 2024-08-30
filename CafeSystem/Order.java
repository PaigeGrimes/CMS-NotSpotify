package CafeSystem;

/**
 * Paige Grimes
 * CafeSystem.Order.java
 * Part 2: Creating the CafeSystem.Order Class
 */
public class Order {
    // Declare the classes attributes
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private double totalAmount;
    public Order() {
        // Default constructor
    }
    public Order(MenuItem item1, MenuItem item2, MenuItem item3) {
        // A constructor for when a customer wants to order 3 items at once.
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }
    public double getTotalAmount() {
        // This getter is to test the CafeSystem.Cafe's placeOrder() method
        return this.totalAmount;
    }
    public void addItem1(MenuItem item) {
        // Adds a CafeSystem.MenuItem to the first slot of the order
        this.item1 = item;
    }
    public void addItem2(MenuItem item) {
        // Adds a CafeSystem.MenuItem to the second slot of the order
        this.item2 = item;
    }
    public void addItem3(MenuItem item) {
        // Adds a CafeSystem.MenuItem to the third slot of the order
        this.item3 = item;
    }
    public void calculateTotal() {
        // Calculates the total amount for the order based on the items added
        //this.totalAmount = item1.getPrice() + item2.getPrice() + item3.getPrice();
        // Use if statements in-case the customer does not order 3 items.
        totalAmount = 0.0;
        if (item1 != null) {
            totalAmount += item1.getPrice();
        }
        if (item2 != null) {
            totalAmount += item2.getPrice();
        }
        if(item3 != null) {
            totalAmount += item3.getPrice();
        }
    }
    public void displayOrderDetails() {
        // Prints out the details of the order, including each item and the total amount
        System.out.println("You ordered: ");
        if (item1 != null) {
            System.out.println(item1.getName() + " for $" + item1.getPrice());
        }
        if (item2 != null) {
            System.out.println(item2.getName() + " for $" + item2.getPrice());
        }
        if(item3 != null) {
            System.out.println(item3.getName() + " for $" + item3.getPrice());
        }
        if(totalAmount == 0.0)
            System.out.println("There were no items ordered.");
        // Display the total and format the price to two decimal places.
        System.out.printf("Your total comes out to $%.2f\n", this.totalAmount);
    }
}
