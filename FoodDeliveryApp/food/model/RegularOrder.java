package food.model;

/**
 * Regular food order.
 * Delivery charge: Rs. 80 (flat)
 * Discount: 10% of the order amount
 */
public class RegularOrder extends FoodOrder implements Discountable {

    private static final double DELIVERY_CHARGE = 80.0;
    private static final double DISCOUNT_PERCENT = 10.0;

    public RegularOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return DELIVERY_CHARGE;
    }

    @Override
    public double applyDiscount() {
        return getAmount() * DISCOUNT_PERCENT / 100.0;
    }

    @Override
    public String getOrderType() {
        return "Regular Order";
    }
}
