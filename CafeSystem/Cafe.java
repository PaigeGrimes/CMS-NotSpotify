package CafeSystem;

/**
 * Paige Grimes
 * CafeSystem.Cafe.java
 * Part 3: Creating the CafeSystem.Cafe class.
 */
public class Cafe {
    // Declare the attributes for the cafe class
    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItem menuItem3;
    private Order currentOrder;

    public void addMenuItem1(MenuItem item) {
        // Adds a CafeSystem.MenuItem to the first slot of the cafe's menu
        this.menuItem1 = item;
    }
    public void addMenuItem2(MenuItem item) {
        // Adds a CafeSystem.MenuItem to the second slot of the cafe's menu
        this.menuItem2 = item;
    }
    public void addMenuItem3(MenuItem item) {
        // Adds a CafeSystem.MenuItem to the third slot of the cafe's menu
        this.menuItem3 = item;
    }
    public void placeOrder(Order order) {
        // Sets the currentOrder to the given order
        this.currentOrder = order;
        // Calculate the total
        currentOrder.calculateTotal();
    }
    public void displayMenu() {
        // Prints out all available items on the cafe's menu.
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("\t\t\t\t\t* CafeSystem.Cafe Menu *");
        System.out.println("----------------------------------------------------");
        if(menuItem1 != null) {
            System.out.println(menuItem1.getCategory() + "----> " + menuItem1.getName() + "----> $" + menuItem1.getPrice());
        }
        if(menuItem2 != null) {
            System.out.println(menuItem2.getCategory() + "----> " + menuItem2.getName() + "----> $" + menuItem2.getPrice());
        }
        if(menuItem3 != null) {
            System.out.println(menuItem3.getCategory() + "----> " + menuItem3.getName() + "----> $" + menuItem3.getPrice());

        }System.out.println("----------------------------------------------------");
    }
}
