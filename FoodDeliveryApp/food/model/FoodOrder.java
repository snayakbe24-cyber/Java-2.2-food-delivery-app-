package food.model;

/**
 * Abstract base class representing a generic food order.
 * Concrete order types (RegularOrder, PremiumOrder) extend this class
 * and provide their own delivery charge logic.
 */
public abstract class FoodOrder {

    // ---- private instance data members ----
    private int orderId;
    private String customerName;
    private double amount;

    // ---- static members ----
    private static String restaurantName = "Spice Route Foods";
    private static int orderCounter = 0;   // counts every order object created

    // ---- constructor ----
    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCounter++;                    // increment counter on every new order
    }

    // ---- getters and setters ----
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String restaurantName) {
        FoodOrder.restaurantName = restaurantName;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }

    // ---- static method to display total orders placed ----
    public static void displayTotalOrders() {
        System.out.println("Total orders placed so far: " + orderCounter);
    }

    // ---- abstract methods to be overridden by subclasses ----
    public abstract double calculateDeliveryCharge();

    public abstract String getOrderType();
}
