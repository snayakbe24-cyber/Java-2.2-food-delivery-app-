package food.utility;

/**
 * Utility class offering static helper methods to validate order data
 * and to build a one-line order summary string.
 */
public class OrderUtility {

    // Private constructor - this is a pure utility class, no instances needed.
    private OrderUtility() {
    }

    /**
     * A valid amount must be a positive, finite number.
     */
    public static boolean validateAmount(double amount) {
        return amount > 0 && !Double.isNaN(amount) && !Double.isInfinite(amount);
    }

    /**
     * A valid customer name must be non-empty and contain only
     * alphabetic characters and spaces.
     */
    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z ]+");
    }

    /**
     * Builds a concise, human readable summary line for an order.
     */
    public static String generateOrderSummary(int orderId, String customerName,
                                               String orderType, double amount) {
        return String.format("Summary -> Order #%d | %s | %s | Bill: Rs. %.2f",
                orderId, customerName, orderType, amount);
    }
}
