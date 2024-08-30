package CafeSystem;

/**
 * Paige Grimes
 * CafeSystem.TestCMS.java
 * Part 4: Testing the system.
 */
public class TestCMS {
    public static void main(String[] args) {
        // Create different CafeSystem.MenuItem objects.
        MenuItem chocolateCake = new MenuItem("Chocolate cake", 3.99, "Desert");
        MenuItem cubanSandwich = new MenuItem("Cuban", 5.29, "Sandwich");
        MenuItem chickenSoup = new MenuItem("Chicken Soup", 4.56, "Soup");
        MenuItem angelFoodCake = new MenuItem("Angel Food Cake", 3.89, "Desert");
        MenuItem phillyCheeseSteak = new MenuItem("Philly Cheese Steak", 5.89, "Sandwich");
        MenuItem tomatoSoup = new MenuItem("Tomato Soup", 3.00, "Soup");

        /* Test CafeSystem.MenuItem class */
        // Test the different setters of the CafeSystem.MenuItem class
        // and displayItemInfo() will test if the getters update.
        chickenSoup.displayItemInfo();
        cubanSandwich.setName("Cuban Sandwich"); // Fix the name of the CafeSystem.MenuItem
        cubanSandwich.displayItemInfo();
        chocolateCake.setPrice(4.00); // Change the price of the chocolate cake
        chocolateCake.displayItemInfo();
        phillyCheeseSteak.setCategory("Sub"); // Change it from a sandwich to a sub
        phillyCheeseSteak.displayItemInfo();

        /* Test the CafeSystem.Order Class */
        // Test the CafeSystem.Order classes default constructor, and a constructor that takes 3 MenuItems as arguments.
        Order sophiesOrder = new Order();
        Order johnsOrder = new Order(tomatoSoup, phillyCheeseSteak, angelFoodCake);
        // Add three MenuItems to Sophie's CafeSystem.Order
        sophiesOrder.addItem1(chickenSoup);
        sophiesOrder.addItem2(cubanSandwich);
        sophiesOrder.addItem3(chocolateCake);

        // Calculate their totals before displaying the CafeSystem.Order details or else they won't be charged! (The totals will be zero.)
        sophiesOrder.calculateTotal();
        johnsOrder.calculateTotal();

        // Display their order details
        System.out.println(); // Add a newline
        sophiesOrder.displayOrderDetails();
        System.out.println(); // Add a newline
        johnsOrder.displayOrderDetails();

        /* Test the CafeSystem.Cafe Class */
        // Create two CafeSystem.Cafe objects
        Cafe newCollegeCafe = new Cafe();
        Cafe southFloridaCafe = new Cafe();

        // Add the MenuItems to the CafeSystem.Cafe's
        newCollegeCafe.addMenuItem1(tomatoSoup);
        newCollegeCafe.addMenuItem2(phillyCheeseSteak);
        newCollegeCafe.addMenuItem3(angelFoodCake);

        southFloridaCafe.addMenuItem1(chickenSoup);
        //southFloridaCafe.addMenuItem2(cubanSandwich);
        southFloridaCafe.addMenuItem3(chocolateCake);

        // Display the menu and place an order
        newCollegeCafe.displayMenu();
        newCollegeCafe.placeOrder(johnsOrder);
        System.out.printf("\nJohns total is: $%.2f\n",johnsOrder.getTotalAmount());


        // Display the menu and place an order
        southFloridaCafe.displayMenu();
        southFloridaCafe.placeOrder(sophiesOrder); // Does nothing?
        System.out.printf("\nSophie's total is: $%.2f\n",sophiesOrder.getTotalAmount());


    }
}
